package com.happysy.gpc.controller;

import com.happysy.gpc.service.TicketPassService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TickerPassController implements Initializable {

    @FXML
    private Text lblMessage;
    @FXML
    private Text lblTextFlow;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblHour;
    @FXML
    private Label lblImageCarousel;
    @FXML
    private Label lblSenhaUltimaSenha;
    @FXML
    private Label lblSetor;
    @FXML
    private ImageView imgLogoTop;

    private final TicketPassService ticketPassService = new TicketPassService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (ticketPassService.isSyncPass(lblSenhaUltimaSenha.getText())) {
            System.out.println("Sincronizando senha");
            lblSenhaUltimaSenha.setText(ticketPassService.syncPass());
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent actionEvent) {
        lblSenhaUltimaSenha.setText(ticketPassService.generatePass());
    }
}