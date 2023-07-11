package com.happysy.gpm.controller;

import com.happysy.gpm.util.DateTimeUtil;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        System.out.println(nodeText.getBoundsInParent().getWidth());
        TranslateTransition transition = new TranslateTransition(Duration.seconds(20), nodeText);
        transition.setFromX(nodeText.getBoundsInParent().getWidth());
        transition.setToX(-nodeText.getBoundsInParent().getWidth());
        transition.setAutoReverse(false);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();
    }

    private void imageCarouselAnimation() {
        Image image = new Image(getClass().getResource("/assets/img/15506.jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.fitWidthProperty().bind(lblImageCarousel.widthProperty());
        imageView.fitHeightProperty().bind(lblImageCarousel.heightProperty());
        lblImageCarousel.setGraphic(imageView);
    }

}

