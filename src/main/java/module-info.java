module com.happysy.gpm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.happysy.gpm to javafx.fxml;
    exports com.happysy.gpm;

    opens com.happysy.gpm.controller to javafx.fxml;
    exports com.happysy.gpm.controller;

}