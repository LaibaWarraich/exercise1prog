package at.ac.fhcampuswien.fhmdb;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import java.util.Optional;

public class WatchlistController {
    @FXML
    private ListView<String> watchlistListView;

    @FXML
    private void initialize() {
        // Hier kannst du Initialisierungen vornehmen, z.B. die Watchlist aus der Datenbank laden
    }

    @FXML
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
    }
}
