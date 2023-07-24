module com.happysy.gpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires okhttp3;
    requires annotations;
    requires com.fasterxml.jackson.databind;
    requires android.json;
    requires java.desktop;

    opens com.happysy.gpc to javafx.fxml;
    exports com.happysy.gpc;

    opens com.happysy.gpc.controller to javafx.fxml;
    exports com.happysy.gpc.controller;

}