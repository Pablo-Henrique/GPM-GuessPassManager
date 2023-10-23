package com.happysy.gpc;

import com.happysy.gpc.util.JDBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        JDBConnection.startConnection();
        JDBConnection.statusConnection();
        launch(args);
        JDBConnection.closeConnection();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parentRoot = new FXMLLoader(Main.class.getResource("/view/GManagerController.fxml")).load();
        Scene scene = new Scene(parentRoot);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
