package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.interfaces.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
    private final JFXButton detailBtn = new JFXButton("Show Details");
    private final Button addToWatchlistBtn = new Button("Add to Watchlist");
    private boolean collapsedDetails = true;
    private final boolean isWatchlistCell;
    private final VBox layout = new VBox(title, detail, genre, releaseYear, rating, directors, writers, mainCast, lengthInMinutes);

    public MovieCell(boolean isWatchlistCell, ClickEventHandler<Movie> addToWatchlistClicked) {
        super();
        this.isWatchlistCell = isWatchlistCell;
        detailBtn.setStyle("-fx-background-color: #f5c518;");
        detailBtn.setPrefWidth(120);
        addToWatchlistBtn.setStyle("-fx-background-color: #f5c518;");
        addToWatchlistBtn.setPrefWidth(120);
        title.getStyleClass().add("text-yellow");
        detail.getStyleClass().add("text-white");
        genre.getStyleClass().add("text-white");
        genre.setStyle("-fx-font-style: italic");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

        // layout
        title.fontProperty().set(title.getFont().font(20));
        detail.setWrapText(true);
        layout.setPadding(new Insets(10));
        layout.spacingProperty().set(10);
        layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);

        detailBtn.setOnMouseClicked(mouseEvent -> {
            if (collapsedDetails) {
                layout.getChildren().add(getDetails());
                collapsedDetails = false;
                detailBtn.setText("Hide Details");
            } else {
                layout.getChildren().remove(5);
                collapsedDetails = true;
                detailBtn.setText("Show Details");
            }
            setGraphic(layout);
        });
        /*
        addToWatchlistBtn.setOnAction(event -> {
            Movie movie = getItem();
            if (movie != null) {
                try {
                    addToWatchlistClicked.onClick(movie);
                } catch (MovieApiException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/
        addToWatchlistBtn.setText(isWatchlistCell ? "Remove" : "Add to watchlist");
        addToWatchlistBtn.setOnMouseClicked(mouseEvent -> {
            try {
                addToWatchlistClicked.onClick(getItem(), isWatchlistCell, addToWatchlistBtn);
            } catch (MovieApiException e) {
                throw new RuntimeException(e);
            }
        });

        // Set up the layout
        //HBox layout = new HBox(10, addToWatchlistBtn, detailBtn);
        setGraphic(layout);
    }

    public static void showExceptionDialog(Throwable throwable) {    // source: http://www.java2s.com/example/java/javafx/show-javafx-exception-dialog.html
        //throwable.printStackTrace();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fhmdb Dialog");
        alert.setHeaderText("Thrown Exception");
        alert.setContentText("App has thrown an exception.");

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(throwable.getMessage());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.show();
    }
    private VBox getDetails() {
        VBox details = new VBox();
        Label releaseYear = new Label("Release Year: " + getItem().getReleaseYear());
        Label lengthInMinutes = new Label("Length: " + getItem().getLengthInMinutes() + " minutes");
        Label rating = new Label("Rating: " + getItem().getRating() + "/10");

        Label directors = new Label("Directors: " + String.join(", ", getItem().getDirector()));
        Label writers = new Label("Writers: " + String.join(", ", getItem().getWriters()));
        Label mainCast = new Label("Main Cast: " + String.join(", ", getItem().getMainCast()));

        releaseYear.getStyleClass().add("text-white");
        rating.getStyleClass().add("text-white");
        directors.getStyleClass().add("text-white");
        writers.getStyleClass().add("text-white");
        mainCast.getStyleClass().add("text-white");
        lengthInMinutes.getStyleClass().add("text-white");
        //layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

        /*releaseYear.getStyleClass().add("text-white");
        lengthInMinutes.getStyleClass().add("text-white");
        rating.getStyleClass().add("text-white");
        directors.getStyleClass().add("text-white");
        writers.getStyleClass().add("text-white");
        mainCast.getStyleClass().add("text-white");*/

        if (isWatchlistCell){
            details.getChildren().add(releaseYear);
            details.getChildren().add(rating);
            details.getChildren().add(lengthInMinutes);
        } else {
            details.getChildren().add(releaseYear);
            details.getChildren().add(rating);
            details.getChildren().add(lengthInMinutes);
            details.getChildren().add(directors);
            details.getChildren().add(writers);
            details.getChildren().add(mainCast);
        }
        return details;
    }

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
            /*String releaseYearText = "Release Year: " + movie.getReleaseYearAsString();
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
            lengthInMinutes.setText(lengthText);*/


            // Color scheme
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            genre.getStyleClass().add("text-white");
           /* releaseYear.getStyleClass().add("text-white");
            rating.getStyleClass().add("text-white");
            directors.getStyleClass().add("text-white");
            writers.getStyleClass().add("text-white");
            mainCast.getStyleClass().add("text-white");
            lengthInMinutes.getStyleClass().add("text-white");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));
*/
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
            layout.getChildren().addAll(title, detail, genre, addToWatchlistBtn, detailBtn);

            setGraphic(layout);
        }

    }
}