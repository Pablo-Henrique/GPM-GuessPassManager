package com.happysy.gpm.util;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static void dateUpdater(Label labelToUpdate) {
        Thread thread = new Thread(() -> {
            while (true) {
                LocalDateTime agora = LocalDateTime.now();
                String horaFormatada = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                Platform.runLater(() -> labelToUpdate.setText(horaFormatada));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
