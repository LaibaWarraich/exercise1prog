package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Custom ListCell implementation for displaying Movie objects in a ListView.
 */
public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genre = new Label();
    private final Label releaseYear = new Label();
    private final Label rating = new Label();
    private final Label directors = new Label();
    private final Label writers = new Label();
    private final Label mainCast = new Label();
    private final Label lengthInMinutes = new Label();

    private final VBox layout = new VBox(title, detail, genre, releaseYear, rating, directors, writers, mainCast, lengthInMinutes);

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setText(null);
            setGraphic(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(movie.getTitle());
            detail.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );
            String genresText = "Genres: " + movie.getGenresAsString();
            genre.setText(genresText);
            String releaseYearText = "Release Year: " + movie.getReleaseYearAsString();
            releaseYear.setText(releaseYearText);
            String ratingText = "Rating: " + movie.getRatingAsString();
            rating.setText(ratingText);
            String directorsText = "Directors: " + movie.getDirectorsAsString();
            directors.setText(directorsText);
            String writersText = "Writers: " + movie.getWritersAsString();
            writers.setText(writersText);
            String mainCastText = "MainCast: " + movie.getMainCastAsString();
            mainCast.setText(mainCastText);
            String lengthText = "Length: " + movie.getLengthInMinutesAsString() + " min";
            lengthInMinutes.setText(lengthText);


            // Color scheme
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            genre.getStyleClass().add("text-white");
            releaseYear.getStyleClass().add("text-white");
            rating.getStyleClass().add("text-white");
            directors.getStyleClass().add("text-white");
            writers.getStyleClass().add("text-white");
            mainCast.getStyleClass().add("text-white");
            lengthInMinutes.getStyleClass().add("text-white");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // Layout
            title.fontProperty().set(title.getFont().font(20));
            detail.setMaxWidth(this.getScene().getWidth() - 30);
            detail.setWrapText(true);
            genre.setMaxWidth(this.getScene().getWidth() - 30);
            genre.setWrapText(true);
            releaseYear.setMaxWidth(this.getScene().getWidth() - 30);
            releaseYear.setWrapText(true);
            rating.setMaxWidth(this.getScene().getWidth() - 30);
            rating.setWrapText(true);
            directors.setMaxWidth(this.getScene().getWidth() - 30);
            directors.setWrapText(true);
            writers.setMaxWidth(this.getScene().getWidth() - 30);
            writers.setWrapText(true);
            mainCast.setMaxWidth(this.getScene().getWidth() - 30);
            mainCast.setWrapText(true);
            lengthInMinutes.setMaxWidth(this.getScene().getWidth() - 30);
            lengthInMinutes.setWrapText(true);
            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);

            layout.getChildren().clear();
            layout.getChildren().addAll(title, detail, genre, releaseYear, rating, directors, writers, mainCast, lengthInMinutes);

            setGraphic(layout);
        }
    }
}