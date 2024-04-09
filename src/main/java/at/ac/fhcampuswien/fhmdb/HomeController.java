package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
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
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
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
    public JFXComboBox<Years> YearComboBox;
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

    public String getQuery() {
        return query;
    }

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
    public HomeController() {
        // Default constructor without parameter
    }

    public HomeController(MovieAPI movieAPI) {
        this.movieAPI = movieAPI;
    }

    // Initialize method for the HomeController
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate the movie list view with initial data
        observableMovies.addAll(getAllMovies());
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());
        observableMovies.addAll(allMovies); // add dummy data to observable list

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

        // Populate the genre combo box with available genres
        List<Genre> genres = new ArrayList<>(Arrays.asList(Genre.values()));
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        // Populate the release year combo box with available years
        List<Years> years = new ArrayList<>(Arrays.asList(Years.values()));
        YearComboBox.getItems().addAll(years);
        YearComboBox.setPromptText("Filter by Release Year");

        // Populate the release year combo box with available ratings
        List<Rating> rating = new ArrayList<>(Arrays.asList(Rating.values()));
        RatingComboBox.getItems().addAll(rating);
        RatingComboBox.setPromptText("Filter by Rating");

        // Set action for the search button
        searchBtn.setOnAction(event -> {
            // Filter movies based on search query and selected genre
            getSearchAndGenre();
            filterMovies();
        });
    }

    // Reset the movies in the list view to the original list
    private void resetMovies() {
        observableMovies.clear();
        observableMovies.addAll(getAllMovies());
    }

    // Get the search query and selected genre from UI components
    private void getSearchAndGenre() {
        query = searchField.getText().toLowerCase();
        selectedGenre = genreComboBox.getValue();
    }

    // Filter the movies based on search query and selected genre
    public void filterMovies() {
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

        List<Movie> filteredMovies = getAllMovies().stream()
                .filter(titleDescriptionPredicate)
                .filter(genrePredicate)
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
}