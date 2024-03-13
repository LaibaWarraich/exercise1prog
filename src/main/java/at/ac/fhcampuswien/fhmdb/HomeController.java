package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
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

    private List<Movie> allMovies = Movie.initializeMovies();

    public ObservableList<Movie> observableMovies = FXCollections.observableArrayList();

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

    public Genre getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(Genre selectedGenre) {
        this.selectedGenre = selectedGenre;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
    //public ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(getAllMovies());
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());
        observableMovies.addAll(allMovies); // add dummy data to observable list

        if (sortBtn != null) {
            sortBtn.setOnAction(event -> sortMovies());
        }

        List<Genre> genres = new ArrayList<>(Arrays.asList(Genre.values()));
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        searchBtn.setOnAction(event -> {
            getSearchAndGenre();
            filterMovies();
        });

        sortBtn.setOnAction(event -> {
            getSearchAndGenre();
            sortMovies();
        });


    }

    private void resetMovies() {
        observableMovies.clear();
        observableMovies.addAll(getAllMovies());
    }

    private void getSearchAndGenre() {
        query = searchField.getText().toLowerCase();
        selectedGenre = genreComboBox.getValue();
    }

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
            observableMovies.setAll(filteredMovies);
    }

    public void sortMovies() {
        Comparator<Movie> titleComparator = Comparator.comparing(Movie::getTitle);
        if (sortBtn.getText().equals("Sort (asc)")) {
            observableMovies.sort(titleComparator);
            sortBtn.setText("Sort (desc)");
        } else {
            observableMovies.sort(titleComparator.reversed());
            sortBtn.setText("Sort (asc)");
        }
    }
}
