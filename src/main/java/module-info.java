module com.happysy.gpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    requires java.sql;

    uses com.happysy.gpc.Main;

    opens com.happysy.gpc to javafx.fxml, javafx.graphics, java.base;
    exports com.happysy.gpc;

    opens com.happysy.gpc.controller to javafx.fxml;
    exports com.happysy.gpc.controller;

}