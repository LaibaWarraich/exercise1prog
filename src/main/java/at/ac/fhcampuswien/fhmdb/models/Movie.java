package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Represents a movie with title, description, and genres.
 */
public class Movie implements Comparable<Movie> {
    private final String title;
    private final String description;
    private final List<Genre> genres;
    private final double rating;
    private final List<String> directors = new ArrayList<>();
    private final List<String> writers = new ArrayList<>();
    private final List<String> mainCast = new ArrayList<>();
    private final int releaseYear;;
    private final int lengthInMinutes;

    /**
     * Constructs a Movie object with the given title, description, and genres.
     * @param title The title of the movie.
     * @param description The description of the movie.
     * @param genres The genres of the movie.
     */
    public Movie(String title, String description, List<Genre> genres, double rating, int releaseYear, int lengthInMinutes) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.lengthInMinutes = lengthInMinutes;
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
    public String getReleaseYearAsString() {
        return String.valueOf(releaseYear);
    }

    public String getRatingAsString() {
        return String.valueOf(rating);
    }

    public String getDirectorsAsString() {
        return listToString(directors);
    }

    public String getWritersAsString() {
        return listToString(writers);
    }

    public String getMainCastAsString() {
        return listToString(mainCast);
    }

    public String getLengthInMinutesAsString() {
        return String.valueOf(lengthInMinutes);
    }

    private String listToString(List<String> list) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String item : list) {
            joiner.add(item);
        }
        return joiner.toString();
    }

    /**
     * Initializes a list of predefined movies.
     * @return The list of initialized movies.
     */
    public static List<Movie> initializeMovies() {
        return MovieAPI.getAllMovies();
    }

    public List<String> getMainCast() {
        return mainCast;
    }
    public List<String> getDirector() {
        return directors;
    }
    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }
}