package at.ac.fhcampuswien.fhmdb.data;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class WatchlistRepository {
    Dao<MovieEntity, Long> dao;

    public WatchlistRepository() {
        this.dao = DatabaseManager.getInstance().getDao();
    }
    public List<MovieEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }
    public List<MovieEntity> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }


    /*public void addToWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        if (dao.queryForEq("title", title).isEmpty()) {
            dao.create(movieToEntity(movie));
            System.out.println("Added " + movie.getTitle() + " to Watchlist");
        }
    }*/
   /* public int addToWatchlist(WatchlistMovieEntity movie) throws SQLException {
        // Überprüfen, ob der Film bereits in der Watchlist vorhanden ist
        if (this.isInWatchlist(movie.setID()) {
            return 0; // Wenn ja, gibt 0 zurück
        } else {
            return dao.create(movie); // Ansonsten wird der Film zur Watchlist hinzugefügt
        }
    }*/

   public void removeFromWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        List<MovieEntity> movies = dao.queryForEq("title", title);
        if (!movies.isEmpty()) {
            dao.delete(movies);
            System.out.println("Deleted " + movie.getTitle() + " from Watchlist");
        }
    }

    public boolean isInWatchlist(String id) throws SQLException {
        for (MovieEntity m : getWatchlist()) {
            if (m.setID().equals(id)) return true;
        }
        return false;
    }






   public void addToWatchlist(Movie movie) throws SQLException, MovieApiException {
       WatchlistMovieEntity watchlistMovieEntity = new WatchlistMovieEntity(movie);
       watchlistMovieEntity.setApiID(movie.setID()); // Hier setze die API-ID oder eine andere eindeutige Kennung des Films
       dao.create((Collection<MovieEntity>) movie);
       System.out.println("Added " + movie.getTitle() + " to Watchlist");
    }


   /* private WatchlistMovieEntity movieToEntity(Movie movie) {
        return new WatchlistMovieEntity(movie.getId(), movie.getTitle(), movie.getDescription(), MovieEntity.genresToString(movie.getGenres()), movie.getReleaseYear(), movie.getImgUrl(), movie.getLengthInMinutes(), movie.getRating());
    }*/







}
