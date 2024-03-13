package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
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

    public List<Genre> getGenres(){
        return genres;
    }
    @Override
    public int compareTo(Movie other) {
        return this.getTitle().compareTo(other.getTitle());
    }

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

    public static List<Movie> initializeMovies(){

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Dark Knight", "A crime thriller featuring Batman.",
                List.of(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER)));
        movies.add(new Movie("Jurassic Park", "Adventure with dinosaurs.",
                List.of(Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.THRILLER)));
        movies.add(new Movie("Toy Story", "Animated adventure of toys coming to life.",
                List.of(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY)));
        movies.add(new Movie("Schindler's List", "Biographical drama about Oskar Schindler.",
                List.of(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY)));
        movies.add(new Movie("Superbad", "Comedy about teenagers on a wild night.",
                List.of(Genre.COMEDY)));
        movies.add(new Movie("The Godfather", "Crime drama about the Corleone family.",
                List.of(Genre.CRIME, Genre.DRAMA)));
        movies.add(new Movie("An Inconvenient Truth", "Documentary about climate change.",
                List.of(Genre.DOCUMENTARY)));
        movies.add(new Movie("Finding Nemo", "Animated adventure under the sea.",
                List.of(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY)));
        movies.add(new Movie("Harry Potter and the Sorcerer's Stone", "Fantasy adventure of a young wizard.",
                List.of(Genre.ADVENTURE, Genre.FAMILY, Genre.FANTASY)));
        movies.add(new Movie("Titanic", "Romantic drama set on the ill-fated ship.",
                List.of(Genre.DRAMA, Genre.ROMANCE)));
        movies.add(new Movie("Interstellar", "Sci-fi adventure exploring space and time.",
                List.of(Genre.ADVENTURE, Genre.DRAMA, Genre.SCIENCE_FICTION)));
        movies.add(new Movie("The Exorcist", "Horror film about demonic possession.",
                List.of(Genre.HORROR)));
        movies.add(new Movie("The Sound of Music", "Musical drama set in Austria.",
                List.of(Genre.BIOGRAPHY, Genre.DRAMA, Genre.MUSICAL)));
        movies.add(new Movie("Sherlock Holmes", "Action-packed mystery with the famous detective.",
                List.of(Genre.ACTION, Genre.ADVENTURE, Genre.CRIME, Genre.MYSTERY, Genre.THRILLER)));
        movies.add(new Movie("Star Wars: Episode IV - A New Hope", "Epic space opera set in a galaxy far, far away.",
                List.of(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY, Genre.SCIENCE_FICTION)));
        movies.add(new Movie("Rocky", "Underdog boxer's journey to the top.",
                List.of(Genre.DRAMA, Genre.SPORT)));
        movies.add(new Movie("Gone Girl", "Mystery thriller about a missing wife.",
                List.of(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY, Genre.THRILLER)));
        movies.add(new Movie("Saving Private Ryan", "War drama set during WWII.",
                List.of(Genre.DRAMA, Genre.WAR)));
        movies.add(new Movie("The Good, the Bad and the Ugly", "Classic western about treasure hunting.",
                List.of(Genre.WESTERN)));
        movies.add(new Movie("The Matrix", "Sci-fi action about a computer hacker.",
                List.of(Genre.ACTION, Genre.SCIENCE_FICTION)));

        return movies;
    }
}
