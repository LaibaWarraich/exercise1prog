package at.ac.fhcampuswien.fhmdb.data;

import com.j256.ormlite.field.DatabaseField;

public class WatchlistMovieEntity {
    @DatabaseField(generatedId = true)
    private long ID;
    private String ApiID;
    public String getApiID() {
        return ApiID;
    }
    public void setApiID(String apiID) {
        ApiID = apiID;
    }
}
