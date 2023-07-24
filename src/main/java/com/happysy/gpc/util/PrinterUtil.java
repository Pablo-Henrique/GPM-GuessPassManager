package com.happysy.gpc.util;

import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.layout.AnchorPane;

public class PrinterUtil {

    public void imprimirFXML() {
        try {
            // Preparar o conteúdo para impressão
            Printer printer = Printer.getDefaultPrinter();
            PrinterJob printerJob = PrinterJob.createPrinterJob(printer);

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/assets/ticket/ticket_layout_default.fxml"));
            AnchorPane root = loader.load();

            if (root != null) {
                boolean success = printerJob.printPage(root);
                if (success) {
                    printerJob.endJob();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
