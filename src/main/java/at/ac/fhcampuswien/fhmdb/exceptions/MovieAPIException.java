package at.ac.fhcampuswien.fhmdb.exceptions;

public class MovieAPIException extends Exception{
    public MovieApiException() {
        super();
    }

    public MovieApiException(String message) {
        super(message);
    }

    public MovieApiException(Throwable cause) {
        super(cause);
    }

    public MovieApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
