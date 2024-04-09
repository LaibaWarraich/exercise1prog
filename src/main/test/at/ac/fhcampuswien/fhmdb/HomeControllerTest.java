package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the HomeController class.
 */
class HomeControllerTest {
    // Unit tests for filtering movies by genre
    @Test
    void genre_all_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.ALL;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(homeController.getAllMovies().contains(movie));
        }
    }
    @Test
    void genre_action_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.ACTION;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_adventure_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.ADVENTURE;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_animation_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.ANIMATION;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_biography_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.BIOGRAPHY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_comedy_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.COMEDY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_crime_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.CRIME;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_drama_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.DRAMA;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_documentary_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.DOCUMENTARY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_family_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.FAMILY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_fantasy_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.FANTASY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_history_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.HISTORY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_horror_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.HORROR;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_musical_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.MUSICAL;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_mystery_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.MYSTERY;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_romance_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.ROMANCE;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_science_fiction_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.SCIENCE_FICTION;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_sport_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.SPORT;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_thriller_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.THRILLER;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_war_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.WAR;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    @Test
    void genre_western_is_correct_filtered(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        Genre genre = Genre.WESTERN;

        // When
        homeController.setQuery("");
        homeController.setSelectedGenre(genre);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getGenres().contains(genre));
        }
    }
    // Unit tests for higher lower case
    @Test
    void higher_to_lower_case_is_working(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        String query = "Toy Story";

        // When
        homeController.setQuery(query);
        homeController.setSelectedGenre(null);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getTitle().contains(query));
        }
    }
    // Unit tests for filtering movies by title or description
    @Test
    void search_description_is_working(){
        HomeController homeController = new HomeController(new MovieAPI());
        // Given
        String query = "Toy Story";

        // When
        homeController.setQuery(query);
        homeController.setSelectedGenre(null);
        homeController.filterMovies();

        // Then
        List<Movie> filteredMovies = homeController.getObservableMovies();
        for (Movie movie : filteredMovies) {
            assertTrue(movie.getDescription().contains(query));
        }
    }
    // Unit tests for sorting movies

    @Test
    void test_movie_sorting_empty_list() {
        HomeController homeController = new HomeController(new MovieAPI());
        List<Movie> emptyList = new ArrayList<>();
        assertDoesNotThrow(() -> homeController.sortMovies(emptyList, false));
    }

    @Test
    void test_movie_sorting_null_list() {
        HomeController homeController = new HomeController(new MovieAPI());
        homeController.observableMovies = null;
        assertThrows(NullPointerException.class, () -> homeController.sortMovies(null, false));
    }

    @Test
    void test_reverse_sorting_order() {
        HomeController homeController = new HomeController(new MovieAPI());

        List<Movie> sortedMovies = Movie.initializeMovies().stream()
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .collect(Collectors.toList());

        homeController.getObservableMovies().addAll(sortedMovies);;

        List<Movie> sortedMoviesAfterSort = homeController.getObservableMovies();
        assertEquals(sortedMovies, sortedMoviesAfterSort);
    }
    @Test
    public void sort_movies_ascending_by_title() {
        // GIVEN
        HomeController homeController = new HomeController(new MovieAPI());
        Movie movie1 = new Movie("The Dark Knight", "A crime thriller featuring Batman.",
                List.of(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 7.0, 2000, 200);
        Movie movie2 = new Movie("An Inconvenient Truth", "Documentary about climate change.",
                List.of(Genre.DOCUMENTARY), 4.0, 2010, 300);
        Movie movie3 = new Movie("Finding Nemo", "Animated adventure under the sea.",
                List.of(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY), 9.0, 2017, 120);

        ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
        observableMovies.add(movie1);
        observableMovies.add(movie2);
        observableMovies.add(movie3);

        homeController.setObservableMovies(observableMovies);

        // WHEN
        homeController.sortMovies(homeController.getObservableMovies(),false);

        // THEN
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie2);
        expectedMovies.add(movie3);
        expectedMovies.add(movie1);

        assertEquals(homeController.getObservableMovies(), expectedMovies);
    }

    @Test
    public void sort_movies_descending_by_title() {
        // GIVEN
        HomeController homeController = new HomeController(new MovieAPI());
        Movie movie1 = new Movie("The Dark Knight", "A crime thriller featuring Batman.",
                List.of(Genre.ACTION, Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 7.0, 2000, 200);
        Movie movie2 = new Movie("An Inconvenient Truth", "Documentary about climate change.",
                List.of(Genre.DOCUMENTARY), 4.0, 2010, 300);
        Movie movie3 = new Movie("Finding Nemo", "Animated adventure under the sea.",
                List.of(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY), 9.0, 2017, 120);

        ObservableList<Movie> observableMovies = FXCollections.observableArrayList();
        observableMovies.add(movie1);
        observableMovies.add(movie2);
        observableMovies.add(movie3);

        homeController.setObservableMovies(observableMovies);

        // WHEN
        homeController.sortMovies(homeController.getObservableMovies(),true);

        // THEN
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(movie1);
        expectedMovies.add(movie3);
        expectedMovies.add(movie2);

        assertEquals(homeController.getObservableMovies(), expectedMovies);
    }

    @Test
    void get_most_popular_actor() {
        HomeController homeController = new HomeController(new MovieAPI());
        List<Movie> movies = homeController.movieAPI.getAllMovies();

        String mostPopularActor = homeController.getMostPopularActor(movies);

        assertNotNull(mostPopularActor);
        System.out.println("Most Popular Actor: " + mostPopularActor);
    }

    @Test
    void get_longest_movie_title() {
        HomeController homeController = new HomeController(new MovieAPI());
        List<Movie> movies = homeController.movieAPI.getAllMovies();

        int longestTitleLength = homeController.getLongestMovieTitle(movies);

        assertTrue(longestTitleLength > 0);
        System.out.println("Longest Movie Title Length: " + longestTitleLength);
    }

    @Test
    void count_movies_from() {
        HomeController homeController = new HomeController(new MovieAPI());
        List<Movie> movies = homeController.movieAPI.getAllMovies();

        String director = "Christopher Nolan";
        long movieCount = homeController.countMoviesFrom(movies, director);

        System.out.println("Movie Count by " + director + ": " + movieCount);
    }


    @Test
    void get_movies_between_years() {
        HomeController homeController = new HomeController(new MovieAPI());
        List<Movie> movies = homeController.movieAPI.getAllMovies();

        int startYear = 2000;
        int endYear = 2010;
        List<Movie> moviesBetweenYears = homeController.getMoviesBetweenYears(movies, startYear, endYear);

        assertFalse(moviesBetweenYears.isEmpty());
        System.out.println("Movies between " + startYear + " and " + endYear + ": " + moviesBetweenYears.size());
    }


}