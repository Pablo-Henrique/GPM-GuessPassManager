package com.happysy.gpm.controller;

import com.happysy.gpm.util.DateTimeUtil;
import com.happysy.gpm.util.FileUtil;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GManagerController implements Initializable {


    @FXML
    private Text lblMessage;
    @FXML
    private Text lblTextFlow;
    @FXML
    private Label lblTemperature;
    @FXML
    private Label lblHour;
    @FXML
    private Label lblImageCarousel;
    @FXML
    private ImageView imgLogoTop;
    @FXML
    private Button btnImprimir;
    @FXML
    private Label lblSenhaUltimaSenha;
    private int[] numeral = {9, 9, 0};

    private String message = "Acesse nosso site WWW.SUPERPINHEIRAO.COM.BR e receba ofertas exclusivas!!!";

    public GManagerController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMessage();
        setLblTextFlow();
        setLblHour();
        animatedTextTransition(lblTextFlow);
        imageCarouselAnimation();
        logoLoader();
    }

    private void setMessage() {
        lblMessage.setText("WWW.SUPERPINHEIRAO.COM.BR");
    }

    private void setLblTextFlow() {
        lblTextFlow.setText(message);
    }

    private void setLblHour() {
        DateTimeUtil.dateUpdater(lblHour);
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

    @FXML
    private void handleButtonAction(ActionEvent actionEvent) {
        numeral[2]++;
        for (int i = 0; i < numeral.length; i++) {
            if (numeral[i] == 10) {
                numeral[i] = 0;
                numeral[i - 1]++;
            }
            if (numeral[1] == 10) {
                numeral[1] = 0;
                numeral[0]++;
            }
        }
        if (numeral[0] <= 9 && numeral[1] <= 9 && numeral[2] <= 9) {
            lblSenhaUltimaSenha.setText(String.format("%d%d%d", numeral[0], numeral[1], numeral[2]));
        }
    }

    private void weather() {
        String chave = "a59197c24c8ab586dde0336425f00899";
        String cidade = "Avaré";

        String urlApi = "http://api.openweathermap.org/data/2.5/weather?q=" + cidade + "&appid=" + chave;

    }

}