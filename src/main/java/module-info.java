module com.happysy.gpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    requires java.sql;

    uses com.happysy.gpc.Main;

    opens com.happysy.gpc to java.base, javafx.fxml, java.compiler, java.sql, javafx.controls;
    exports com.happysy.gpc;

    opens com.happysy.gpc.dto;
    exports com.happysy.gpc.dto;

    opens com.happysy.gpc.controller;
    exports com.happysy.gpc.controller;

    opens com.happysy.gpc.repository;
    exports com.happysy.gpc.repository;

    opens com.happysy.gpc.service;
    exports com.happysy.gpc.service;

}