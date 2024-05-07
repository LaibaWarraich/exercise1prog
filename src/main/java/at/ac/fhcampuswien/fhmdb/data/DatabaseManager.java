package at.ac.fhcampuswien.fhmdb.data;

import at.ac.fhcampuswien.fhmdb.ui.MovieCell;

import java.sql.SQLException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseManager {
    public static final String DB_URL = "jdbc:h2:file: ./db/moviesDB";
    public static final String username = "user";
    public static final String password = "pass";

    private static ConnectionSource connectionSource;

    private Dao<MovieEntity, Long> dao;

    private static DatabaseManager instance;

    private DatabaseManager() {
        try {
            createConnectionSource();
            dao = DaoManager.createDao(connectionSource, MovieEntity.class);
            createTables();
        } catch (SQLException e) {
            //MovieCell.showExceptionDialog(new DatabaseException("Database problem"));
        }
    }
    public static DatabaseManager getInstance()
    {
        if(instance == null)
        {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Dao<MovieEntity, Long> getDao()
    {
        return dao;
    }

    public  ConnectionSource getConnectionSource()
    {
        return connectionSource;
    }

    private static void createConnectionSource() throws SQLException {
        connectionSource = new JdbcConnectionSource(DB_URL, username, password);
    }

    private void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, MovieEntity.class);
    }

}
