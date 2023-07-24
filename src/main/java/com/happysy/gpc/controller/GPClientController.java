package com.happysy.gpc.controller;

import com.happysy.gpc.service.GPCService;
import com.happysy.gpc.util.DateTimeUtil;
import com.happysy.gpc.util.FileUtil;
import com.happysy.gpc.util.PrinterUtil;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GPClientController implements Initializable {


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
    private int[] numeral = {0, 0, 0};
    private String message = "Acesse nosso site WWW.SUPERPINHEIRAO.COM.BR e receba ofertas exclusivas!!!";

    private PrinterUtil service = new PrinterUtil();

    private GPCService gpcService = new GPCService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMessage();
        setLblTextFlow();
        setLblHour();
        animatedTextTransition(lblTextFlow);
        imageCarouselAnimation();
        logoLoader();
        setSetor();
        DateTimeUtil.dateUpdate(lblDate);
        setLblSenhaUltimaSenha();
    }

    private void setMessage() {
        lblMessage.setText("WWW.SUPERPINHEIRAO.COM.BR");
    }

    private void setLblTextFlow() {
        lblTextFlow.setText(message);
    }

    private void setLblHour() {
        DateTimeUtil.hoursUpdate(lblHour);
    }

    private void animatedTextTransition(Text nodeText) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(50), nodeText);
        transition.setFromX(nodeText.getBoundsInParent().getWidth() + nodeText.getText().length());
        transition.setToX(-nodeText.getBoundsInParent().getWidth());
        transition.setAutoReverse(false);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();
    }

    private void imageCarouselAnimation() {
        FileUtil.imageCarousel(lblImageCarousel);
    }

    private void logoLoader() {
        imgLogoTop.setImage(new Image(getClass().getResource("/assets/img/Logo/logoPinheirao.png").toExternalForm()));
    }

    private void setSetor() {
        lblSetor.setText("FRIOS");
    }

    private void setLblSenhaUltimaSenha() {
        if (gpcService.) {

        }
        lblSenhaUltimaSenha.setText(gpcService.decimalCountToString());
    }

    @FXML
    private void handleButtonAction(ActionEvent actionEvent) {
        gpcService.generateTicketPass();
    }
}