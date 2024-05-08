package at.ac.fhcampuswien.fhmdb.interfaces;

import javafx.scene.control.Button;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;

public interface ClickEventHandler<T> {
    void onClick(T t, boolean isWatchlistCell, Button addToWatchlistBtn) throws MovieApiException;
}
