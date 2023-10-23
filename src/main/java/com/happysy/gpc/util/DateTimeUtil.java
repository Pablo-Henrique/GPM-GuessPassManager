package com.happysy.gpc.util;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static void hoursUpdate(Label label) {
        Thread thread = new Thread(() -> {
            while (true) {
                LocalDateTime agora = LocalDateTime.now();
                String horaFormatada = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                Platform.runLater(() -> label.setText(horaFormatada));

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

    public static void dateUpdate(Label label) {
        Thread thread = new Thread(() -> {
            while (true) {
                LocalDateTime agora = LocalDateTime.now();
                String horaFormatada = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Platform.runLater(() -> label.setText(horaFormatada));

                try {
                    Thread.sleep(Duration.ofHours(24));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
