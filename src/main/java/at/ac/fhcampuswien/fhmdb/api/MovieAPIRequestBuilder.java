package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;


public class MovieAPIRequestBuilder {
    // StringBuilder zum Zusammenstellen der URL
    private StringBuilder urlBuilder;

    // Trennzeichen für Parameter in der URL
    private final String DELIMITER = "&";

    // Flag, um zu überprüfen, ob bereits Parameter vorhanden sind
    private boolean hasParameters = false;

    // Konstruktor, der die Basis-URL initialisiert
    public MovieAPIRequestBuilder(String baseUrl){
        urlBuilder = new StringBuilder(baseUrl);
    }

    // Methode zum Hinzufügen des Suchbegriffs zur URL
    public MovieAPIRequestBuilder appendQuery(String query){
        if(query != null && !query.isEmpty()){
            appendParameter("query=" + query);
        }
        return this;
    };

    // Methode zum Hinzufügen des Genres zur URL
    public MovieAPIRequestBuilder appendGenre(Genre genre){
        if(genre != null){
            appendParameter("genre=" + genre);
        }
        return this;
    };

    // Methode zum Hinzufügen des Erscheinungsjahres zur URL
    public MovieAPIRequestBuilder appendReleaseYear(String releaseYear){
        if(releaseYear != null && !releaseYear.isEmpty()){
            appendParameter("releaseYear=" + releaseYear);
        }
        return this;
    };

    // Methode zum Hinzufügen der Mindestbewertung zur URL
    public MovieAPIRequestBuilder appendRatingFrom(String ratingFrom){
        if(ratingFrom != null && !ratingFrom.isEmpty()){
            appendParameter("ratingFrom=" + ratingFrom);
        }
        return this;
    };

    // Private Methode zum Hinzufügen eines Parameters zur URL
    private void appendParameter(String parameter){
        // Überprüfen, ob bereits Parameter vorhanden sind
        if(hasParameters){
            urlBuilder.append(DELIMITER); // Falls ja, Trennzeichen hinzufügen
        } else {
            urlBuilder.append("?"); // Falls nein, das erste Fragezeichen hinzufügen
            hasParameters = true; // Setzen des Flags auf true
        }
        urlBuilder.append(parameter); // Hinzufügen des Parameters zur URL
    }

    // Methode zum Zusammenstellen und Abrufen der endgültigen URL
    public String build(){
        return urlBuilder.toString(); // Rückgabe der zusammengestellten URL
    }
}
