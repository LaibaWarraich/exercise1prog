package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
import at.ac.fhcampuswien.fhmdb.data.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.interfaces.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Rating;
import at.ac.fhcampuswien.fhmdb.models.Years;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView<Movie> movieListView;

    @FXML
    public JFXComboBox<Genre> genreComboBox;

    @FXML
    public JFXButton sortBtn;
    @FXML
    public VBox mainPane;

    public JFXComboBox<Years> yearComboBox;
    public JFXComboBox<Rating> RatingComboBox;

    private List<Movie> allMovies = Movie.initializeMovies();

    public ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
    public void setObservableMovies(ObservableList<Movie> observableMovies) {
        this.observableMovies = observableMovies;
    }

    public ObservableList<Movie> getObservableMovies() {
        return observableMovies;
    }

    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    private Genre selectedGenre;

    public void setSelectedGenre(Genre selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public MovieAPI movieAPI;
    private Rating selectedRating;
    private Years selectedYear;
    private WatchlistRepository repository = new WatchlistRepository();

    public HomeController() throws MovieApiException {
        // Default constructor without parameter
    }

    public HomeController(MovieAPI movieAPI) throws MovieApiException {
        this.movieAPI = movieAPI;
    }

    // Initialize method for the HomeController
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate the movie list view with initial data

        observableMovies.addAll(getAllMovies());
        movieListView.setItems(observableMovies);   // set the items of the listview to the observable list
        movieListView.setCellFactory(movieListView -> new MovieCell(false, onAddToWatchlistClicked));

        // Set action for the sort button
        if (sortBtn != null) {
            sortBtn.setOnAction(actionEvent -> {
                if (sortBtn.getText().equals("Sort (asc)")) {
                    // Sort movies in ascending order
                    sortMovies(observableMovies, false);
                    sortBtn.setText("Sort (desc)");
                } else {
                    // Sort movies in descending order
                    sortMovies(observableMovies, true);
                    sortBtn.setText("Sort (asc)");
                }
            });
        }

        List<Genre> genres = new ArrayList<>(Arrays.asList(Genre.values()));
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        List<Years> years = new ArrayList<>(Arrays.asList(Years.values()));
        yearComboBox.getItems().addAll(years);
        yearComboBox.setPromptText("Filter by Release Year");

        List<Rating> rating = new ArrayList<>(Arrays.asList(Rating.values()));
        RatingComboBox.getItems().addAll(rating);
        RatingComboBox.setPromptText("Filter by Rating");

        // Set action for the search button
        searchBtn.setOnAction(event -> {
            // Filter movies based on search query and selected genre
            getSearchGenreYearRating();
            try {
                filterMovies();
            } catch (MovieApiException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private final ClickEventHandler onAddToWatchlistClicked = (clickedItem, isWatchlistCell, addToWatchlistBtn) -> {
        if (isWatchlistCell) {
            try {
                repository.removeFromWatchlist((Movie)clickedItem);
                FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("watchlist-view.fxml"));
                Parent root = FXMLLoader.load(fxmlLoader.getLocation());
                Scene scene = addToWatchlistBtn.getScene();
                scene.setRoot(root);
            } catch (SQLException e) {
                MovieCell.showExceptionDialog(new DatabaseException("Error by deleting movies"));
            } catch (IOException e) {
                MovieCell.showExceptionDialog(new IllegalArgumentException("Fxml cannot be loaded"));
            }
        } else {
            try {
                repository.addToWatchlist((Movie)clickedItem);
            } catch (SQLException e) {
                MovieCell.showExceptionDialog(new DatabaseException("Error by adding to watchlist"));
            }
        }
    };
    public void addToWatchlist(Movie movie) {
        try {
            repository.addToWatchlist(movie);
        } catch (SQLException e) {
            MovieCell.showExceptionDialog(new DatabaseException("Error by adding to watchlist"));
        } catch (MovieApiException e) {
            MovieCell.showExceptionDialog(new DatabaseException("Error by adding to watchlist"));
        }
    }

    // Reset the movies in the list view to the original list
    private void resetMovies() {
        observableMovies.clear();
        observableMovies.addAll(getAllMovies());
    }

    // Get the search query and selected genre from UI components
    private void getSearchGenreYearRating() {
        query = searchField.getText().toLowerCase();
        selectedGenre = genreComboBox.getValue();
        selectedYear = yearComboBox.getValue();
        selectedRating = RatingComboBox.getValue();
    }

    // Filter the movies based on search query, selected genre, releaseYear and rating(Kommastelle wird ignoriert)
    public void filterMovies() throws MovieApiException {
        resetMovies();

        Predicate<Movie> titleDescriptionPredicate = movie ->
                movie.getTitle().toLowerCase().contains(query) ||
                        movie.getDescription().toLowerCase().contains(query);

        Predicate<Movie> genrePredicate = movie -> {
            if (selectedGenre == null || selectedGenre == Genre.ALL)
                return true;
            else
                return movie.getGenres().contains(selectedGenre);
        };

        Predicate<Movie> releaseYearPredicate = movie -> {
            if (selectedYear == null || selectedYear == Years.ALL)
                return true;
            else
                return movie.getReleaseYear() == selectedYear.getYear();
        };

        Predicate<Movie> ratingPredicate = movie -> {
            if (selectedRating == null || selectedRating == Rating.ALL)
                return true;
            else
                return (int) movie.getRating() == selectedRating.getRating();
        };

        List<Movie> filteredMovies = getAllMovies().stream()
                .filter(titleDescriptionPredicate)
                .filter(genrePredicate)
                .filter(releaseYearPredicate)
                .filter(ratingPredicate)
                .collect(Collectors.toList());

        observableMovies.setAll(filteredMovies);
    }

    // Sort the movies in the list based on the specified order
    public void sortMovies(List<Movie> movies, boolean descending) {
        if (descending) movies.sort(Comparator.reverseOrder());
        else Collections.sort(movies);
    }


    public String getMostPopularActor(List<Movie> movies) {
        // Gruppierung der Schauspieler und Zählen ihrer Vorkommen in den Hauptbesetzungen der Filme
        Map<String, Long> actorCounts = movies.stream()
                .flatMap(movie -> movie.getMainCast().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));

        // Ermittlung des Schauspielers mit den meisten Vorkommen
        return actorCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null); // Wenn keine Schauspieler gefunden werden, wird null zurückgegeben
    }

    public int getLongestMovieTitle(List<Movie> movies) {
        // Ermittlung der Länge des längsten Filmtitels
        return movies.stream()
                .mapToInt(movie -> movie.getTitle().length())
                .max()
                .orElse(0); // Wenn keine Filme gefunden werden, wird 0 zurückgegeben
    }

    public long countMoviesFrom(List<Movie> movies, String director) {
        return movies.stream()
                .filter(movie -> movie.getDirector() != null && movie.getDirector().contains(director))
                .count();
    }

    public List<Movie> getMoviesBetweenYears(List<Movie> movies, int startYear, int endYear) {
        // Filtern der Filme zwischen den gegebenen Jahren
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .collect(Collectors.toList());
    }
    public void loadWatchlistView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("watchlist-view.fxml"));
        try {
            Parent root = fxmlLoader.load();
            WatchlistController controller = fxmlLoader.getController();
            controller.initialize();
            Scene scene = new Scene(root, 890, 620);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            MovieCell.showExceptionDialog(new IllegalArgumentException("Error while loading"));
        }
    }
}