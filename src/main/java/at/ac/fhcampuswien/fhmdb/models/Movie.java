package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private String genres;

    public Movie(String title, String description, String genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres(){
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here.

        movies.add(new Movie("The Dark Knight", "A crime thriller featuring Batman.", "Action, Crime, Drama, Thriller"));
        movies.add(new Movie("Jurassic Park", "Adventure with dinosaurs.", "Adventure, Science Fiction, Thriller"));
        movies.add(new Movie("Toy Story", "Animated adventure of toys coming to life.", "Animation, Adventure, Comedy"));
        movies.add(new Movie("Schindler's List", "Biographical drama about Oskar Schindler.", "Biography, Drama, History"));
        movies.add(new Movie("Superbad", "Comedy about teenagers on a wild night.", "Comedy"));
        movies.add(new Movie("The Godfather", "Crime drama about the Corleone family.", "Crime, Drama"));
        movies.add(new Movie("An Inconvenient Truth", "Documentary about climate change.", "Documentary"));
        movies.add(new Movie("Finding Nemo", "Animated adventure under the sea.", "Animation, Adventure, Comedy"));
        movies.add(new Movie("Harry Potter and the Sorcerer's Stone", "Fantasy adventure of a young wizard.", "Adventure, Family, Fantasy"));
        movies.add(new Movie("Titanic", "Romantic drama set on the ill-fated ship.", "Drama, Romance"));
        movies.add(new Movie("Interstellar", "Sci-fi adventure exploring space and time.", "Adventure, Drama, Sci-Fi"));
        movies.add(new Movie("The Exorcist", "Horror film about demonic possession.", "Horror"));
        movies.add(new Movie("The Sound of Music", "Musical drama set in Austria.", "Biography, Drama, Musical"));
        movies.add(new Movie("Sherlock Holmes", "Action-packed mystery with the famous detective.", "Action, Adventure, Crime, Mystery, Thriller"));
        movies.add(new Movie("Star Wars: Episode IV - A New Hope", "Epic space opera set in a galaxy far, far away.", "Action, Adventure, Fantasy, Sci-Fi"));
        movies.add(new Movie("Rocky", "Underdog boxer's journey to the top.", "Drama, Sport"));
        movies.add(new Movie("Gone Girl", "Mystery thriller about a missing wife.", "Crime, Drama, Mystery, Thriller"));
        movies.add(new Movie("Saving Private Ryan", "War drama set during WWII.", "Drama, War"));
        movies.add(new Movie("The Good, the Bad and the Ugly", "Classic western about treasure hunting.", "Western"));
        movies.add(new Movie("The Matrix", "Sci-fi action about a computer hacker.", "Action, Sci-Fi"));

        return movies;
    }
}
