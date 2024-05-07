package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import java.io.IOException;

import okhttp3.*;
// from JSON to Java Object and back
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// sample request URL: http://localhost:8080/movies?genre=COMEDY&releaseYear=2000
// fh-server API URL: "https://prog2.fh-campuswien.ac.at/movies"
// local API URL: "http://localhost:8080/movies"
// Diese Klasse stellt Methoden bereit, um Filme von einer API abzurufen
public class MovieAPI {
    // Basis-URL der API
    private static final String BASEURL = "https://prog2.fh-campuswien.ac.at/movies";

    // Methode zum Abrufen aller Filme von der API
    public static List<Movie> getAllMovies() throws MovieApiException {
        return getMovies(null, null, null, null);
    }

    public static List<Movie> getMovies(String query, Genre genre, String releaseYear, String ratingFrom) throws MovieApiException {
        String url = buildRequestUrl(query, genre, releaseYear, ratingFrom);
        Request request = createRequestWithHeaders(url);
        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new MovieApiException("Failed to fetch movies: " + response.code());
            }

            String responseBody = response.body().string();
            return parseMoviesFromResponse(responseBody);
        } catch (IOException e) {
            throw new MovieApiException("Error fetching movies: " + e.getMessage(), e);
        }
    }

    // Methode zum Zusammenstellen der Anfrage-URL mit den Parametern
    private static String buildRequestUrl(String query, Genre genre, String releaseYear, String ratingFrom) throws MovieApiException {
        // MovieAPIRequestBuilder verwenden, um die URL zusammenzustellen
        return new MovieAPIRequestBuilder(BASEURL)
                .appendQuery(query)
                .appendGenre(genre)
                .appendReleaseYear(releaseYear)
                .appendRatingFrom(ratingFrom)
                .build();
    }

    // Methode zum Erstellen der Anfrage mit den erforderlichen Headern
    private static Request createRequestWithHeaders(String url) {
        // Anfrageobjekt mit der URL und erforderlichen Header erstellen
        return new Request.Builder()
                .url(url)
                .removeHeader("User-Agent") // Bisherige "User-Agent" Header entfernen
                .addHeader("User-Agent", "http.agent") // Neuen "User-Agent" Header hinzufügen
                .build();
    }

    // Methode zum Parsen der Filmobjekte aus der API-Antwort
    private static List<Movie> parseMoviesFromResponse(String responseBody) {
        // Gson-Objekt zum Parsen von JSON-Strings in Java-Objekte erstellen
        Gson gson = new Gson();
        // Filme aus dem JSON-String parsen und in ein Array von Movie-Objekten konvertieren
        Movie[] movies = gson.fromJson(responseBody, Movie[].class);
        // Array von Movie-Objekten in eine Liste umwandeln und zurückgeben
        return Arrays.asList(movies);
    }
}
