package at.ac.fhcampuswien.fhmdb.data;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collection;
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


    public void addToWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        if (dao.queryForEq("title", title).isEmpty()) {
            dao.create(movieToEntity(movie));
            System.out.println("Added " + movie.getTitle() + " to Watchlist");
        }
    }

    public void removeFromWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        List<MovieEntity> movies = dao.queryForEq("title", title);
        if (!movies.isEmpty()) {
            dao.delete(movies);
            System.out.println("Deleted " + movie.getTitle() + " from Watchlist");
        }
    }








   /*public void addToWatchlist(Movie movie) throws SQLException {
        WatchlistMovieEntity watchlistMovieEntity = new WatchlistMovieEntity(movie);
        watchlistMovieEntity.setApiID(movie.getId()); // Hier setze die API-ID oder eine andere eindeutige Kennung des Films
        dao.create(movieT);
        System.out.println("Added " + movie.getTitle() + " to Watchlist");
    }

    */


    private WatchlistMovieEntity movieToEntity(Movie movie) {
        return new WatchlistMovieEntity(movie.getId(), movie.getTitle(), movie.getDescription(), MovieEntity.genresToString(movie.getGenres()), movie.getReleaseYear(), movie.getImgUrl(), movie.getLengthInMinutes(), movie.getRating());
    }







}
