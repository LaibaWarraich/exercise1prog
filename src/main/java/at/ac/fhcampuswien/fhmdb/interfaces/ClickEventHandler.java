package at.ac.fhcampuswien.fhmdb.interfaces;

import at.ac.fhcampuswien.fhmdb.exceptions.MovieApiException;

public interface ClickEventHandler<T> {
    void onClick(T t) throws MovieApiException;
}
