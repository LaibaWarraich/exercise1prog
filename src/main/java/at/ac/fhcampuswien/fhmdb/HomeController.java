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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies); // add dummy data to observable list


        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view.
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        List<Genre> genres = Arrays.asList(Genre.values());  // Konvertieren des Genre-Enums in eine Liste
        genreComboBox.getItems().addAll(genres);
        genreComboBox.setPromptText("Filter by Genre");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        searchBtn.setOnAction(event -> filterMovies());
        sortBtn.setOnAction(event -> sortMovies());

    }

    private void filterMovies() {
        String query = searchField.getText().toLowerCase();
        Genre selectedGenre = genreComboBox.getValue() != null ? Genre.valueOf(genreComboBox.getValue().toString()) : null;

        Predicate<Movie> titleDescriptionPredicate = movie ->
                movie.getTitle().toLowerCase().contains(query) ||
                        movie.getDescription().toLowerCase().contains(query);

        Predicate<Movie> genrePredicate = movie ->
                selectedGenre == null || movie.getGenres().contains(selectedGenre);

        List<Movie> filteredMovies = allMovies.stream()
                .filter(titleDescriptionPredicate)
                .filter(genrePredicate)
                .collect(Collectors.toList());

        observableMovies.setAll(filteredMovies);
    }

        private void sortMovies() {
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