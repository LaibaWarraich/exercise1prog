package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;

import okhttp3.*;
// from JSON to Java Object and back
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// sample request URL: http://localhost:8080/movies?genre=COMEDY&releaseYear=2000
// fh-server API URL: "https://prog2.fh-campuswien.ac.at/movies"
// local API URL: "http://localhost:8080/movies"
public class MovieAPI {
    private static final String BASEURL = "https://prog2.fh-campuswien.ac.at/movies";

    public static List<Movie> getAllMovies() {
        return getMovies(null, null, null, null);
    }

    public static List<Movie> getMovies(String query, Genre genre, String releaseYear, String ratingFrom) {
        String url = buildRequestUrl(query, genre, releaseYear, ratingFrom);

        Request request = createRequestWithHeaders(url);

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            return parseMoviesFromResponse(responseBody);
        } catch (Exception e) {
            System.err.println("Error fetching movies: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    private static String buildRequestUrl(String query, Genre genre, String releaseYear, String ratingFrom) {
        return new MovieAPIRequestBuilder(BASEURL)
                .appendQuery(query)
                .appendGenre(genre)
                .appendReleaseYear(releaseYear)
                .appendRatingFrom(ratingFrom)
                .build();
    }

    private static Request createRequestWithHeaders(String url) {
        return new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "http.agent")
                .build();
    }

    private static List<Movie> parseMoviesFromResponse(String responseBody) {
        Gson gson = new Gson();
        Movie[] movies = gson.fromJson(responseBody, Movie[].class);
        return Arrays.asList(movies);
    }
}
