module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires okhttp3;
    requires com.google.gson;
    requires annotations;
    requires java.sql;
    requires ormlite.jdbc;

    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    opens at.ac.fhcampuswien.fhmdb.models to com.google.gson;
    exports at.ac.fhcampuswien.fhmdb;
    exports at.ac.fhcampuswien.fhmdb.models;
    exports at.ac.fhcampuswien.fhmdb.api;
    opens at.ac.fhcampuswien.fhmdb.api to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb.interfaces;
    opens at.ac.fhcampuswien.fhmdb.interfaces to javafx.fxml;
}