package com.happysy.gpc.util;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.time.Duration;

public class FileUtil {

    public static void imageCarousel(Label node) {
        Thread imageCarouselThread = new Thread(() -> {
            for (int i = 0; i <= imageFolderFiles().length; i++) {
                if (i == imageFolderFiles().length) {
                    i = 0;
                }
                Image image = new Image(FileUtil.class.getResource("/assets/img/Banners/" + imageFolderFiles()[i]).toExternalForm());
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(false);
                imageView.fitWidthProperty().bind(node.widthProperty());
                imageView.fitHeightProperty().bind(node.heightProperty());

                Platform.runLater(() -> node.setGraphic(imageView));

                try {
                    Thread.sleep(Duration.ofSeconds(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        imageCarouselThread.setDaemon(true);
        imageCarouselThread.start();
    }

    public static String[] imageFolderFiles() {
        return new File("/home/pablo/Documentos/projects/GuessPassManager/src/main/resources/assets/img/Banners").list();
    }


}
