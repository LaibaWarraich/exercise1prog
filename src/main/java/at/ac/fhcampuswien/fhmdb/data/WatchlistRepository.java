package at.ac.fhcampuswien.fhmdb.data;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    Dao<Movie, Integer> dao;

    public WatchlistRepository(Dao<Movie, Integer> dao) {
        this.dao = dao;
    }

    public WatchlistRepository() {

    }

    public List<Movie> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }

    public void addToWatchlist(Movie movie) throws SQLException, MovieApiException {
        if (dao != null) {
            try {
                // Füge den Film zur Watchlist hinzu
                dao.create(movie);
            } catch (SQLException e) {
                // Handle die SQLException entsprechend
                e.printStackTrace();
            }
        } else {
            System.out.println("Das DAO-Feld wurde nicht initialisiert.");
            // Hier könntest du entsprechend reagieren, z.B. eine Fehlermeldung anzeigen oder das Programm beenden.
        }
    }

    public void removeFromWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        List<Movie> movies = dao.queryForEq("title", title);
        if (!movies.isEmpty()) {
            dao.delete(movies);
            System.out.println("Deleted " + movie.getTitle() + " from Watchlist");
        }
    }

    public boolean isInWatchlist(String id) throws SQLException {
        for (Movie m : getWatchlist()) {
            if (m.getApiID().equals(id)) return true;
        }
        return false;
    }

    public List<MovieEntity> getAll() {
        return null;
    }
}


