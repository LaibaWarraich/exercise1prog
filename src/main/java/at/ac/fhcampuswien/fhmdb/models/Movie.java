package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a movie with title, description, and genres.
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private String description;
    private List<Genre> genres;

    /**
     * Constructs a Movie object with the given title, description, and genres.
     * @param title The title of the movie.
     * @param description The description of the movie.
     * @param genres The genres of the movie.
     */
    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    /**
     * Gets the title of the movie.
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the movie.
     * @return The description of the movie.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the genres of the movie.
     * @return The genres of the movie.
     */
    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public int compareTo(Movie other) {
        return this.getTitle().compareTo(other.getTitle());
    }

    /**
     * Gets the string representation of genres separated by commas.
     * @return The string representation of genres.
     */
    public String getGenresAsString() {
        StringBuilder genresString = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            genresString.append(genres.get(i));
            if (i < genres.size() - 1) {
                genresString.append(", ");
            }
        }
        return genresString.toString();
    }

    /**
     * Initializes a list of predefined movies.
     * @return The list of initialized movies.
     */
    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Dark Knight", "A crime thriller featuring Batman.",
                List.of(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER)));
        // Add more movies here...
        return movies;
    }
}