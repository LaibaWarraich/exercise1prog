package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test
    void genre_all_is_correct_filtered(){
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
        HomeController homeController = new HomeController();
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
    @Test
    void higher_to_lower_case_is_working(){
        HomeController homeController = new HomeController();
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

    @Test
    void search_description_is_working(){
        HomeController homeController = new HomeController();
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
}