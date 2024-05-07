package at.ac.fhcampuswien.fhmdb.data;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    Dao<MovieEntity, Long> dao;

    public WatchlistRepository()
    {
        this.dao = DatabaseManager.getInstance().getDao();
    }
    public List<MovieEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }

    /*
    public void addToWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        if (dao.queryForEq("title", title).isEmpty()) {
            dao.create(new MovieEntity(movie));
            System.out.println("Added " + movie.getTitle() + " to Watchlist");
        }
    }
    */


   public void addToWatchlist(Movie movie) throws SQLException {
        /*WatchlistMovieEntity watchlistMovieEntity = new WatchlistMovieEntity();
        watchlistMovieEntity.setApiID(movie.getApiID()); // Hier setze die API-ID oder eine andere eindeutige Kennung des Films
        dao.create(watchlistMovieEntity);
        System.out.println("Added " + movie.getTitle() + " to Watchlist");*/
    }

    public void removeFromWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        List<MovieEntity> movies = dao.queryForEq("title", title);
        if (!movies.isEmpty()) {
            dao.delete(movies);
            System.out.println("Deleted " + movie.getTitle() + " from Watchlist");
        }
    }

}
