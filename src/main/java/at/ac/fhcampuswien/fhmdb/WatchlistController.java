package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.data.MovieEntity;
import at.ac.fhcampuswien.fhmdb.data.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.data.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.interfaces.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WatchlistController {
    @FXML
    public JFXListView movieWatchlistView;
    @FXML
    public VBox mainPane;
    private WatchlistRepository repository = new WatchlistRepository();

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
    @FXML
    public void initialize() {
        List<MovieEntity> watchlist = repository.getAll();

        ObservableList<Movie> movies = FXCollections.observableArrayList(
                watchlist.stream()
                        .map(movieEntity -> {
                            try {
                                return movieEntity.toMovie();
                            } catch (MovieApiException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.toList())
        );

        movieWatchlistView.setItems(movies);
        movieWatchlistView.setCellFactory(movieListView -> new MovieCell(true, onAddToWatchlistClicked));
    }


    @FXML
    public void loadHomeView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            MovieCell.showExceptionDialog(new IllegalArgumentException("Error while loading"));
        }
    }

    /*@FXML
    private void removeFromWatchlist() {
        String selectedItem = watchlistListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Removal");
            alert.setHeaderText("Remove Movie from Watchlist");
            alert.setContentText("Are you sure you want to remove this movie from your watchlist?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Hier könntest du den ausgewählten Eintrag aus der Watchlist entfernen
                watchlistListView.getItems().remove(selectedItem);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Movie Selected");
            alert.setContentText("Please select a movie to remove from the watchlist.");
            alert.showAndWait();
        }
    }

    @FXML
    private void addToWatchlist() {
        String selectedItem = watchlistListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Hier könntest du den ausgewählten Eintrag zur Watchlist hinzufügen
            // z.B. durch Speichern in der Datenbank oder einer anderen Datenstruktur
            // Anschließend kannst du die Watchlist aktualisieren
            // watchlistListView.getItems().add(selectedItem);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Movie Selected");
            alert.setContentText("Please select a movie to add to the watchlist.");
            alert.showAndWait();
        }
    }*/

}
