package com.example.aop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MipsController implements Initializable {
    @FXML private Button startBtn;
    @FXML private Button nextBtn;
    @FXML private Button previousBtn;
    @FXML private ImageView picture;

    private int counter = 1;
    private final int max_frames = 5;
    private String example = "leitura";

    @FXML
    protected void onStartBtnClick() {
        File f = new File("src/main/resources/com/example/aop/img/" + example + "/Frame 1.png");
        Image pic = new Image(f.toURI().toString());
        picture.setImage(pic);
        counter = 1;
    }

    @FXML
    protected void onNextBtnClick() {
        if (counter < max_frames) {
            File f = new File("src/main/resources/com/example/aop/img/" + example + "/Frame " + (counter + 1) + ".png");
            Image pic = new Image(f.toURI().toString());
            picture.setImage(pic);
            counter++;
        }
    }

    @FXML
    protected void onPreviousBtnClick() {
        if (counter > 1) {
            File f = new File("src/main/resources/com/example/aop/img/" + example + "/Frame " + (counter-1) + ".png");
            Image pic = new Image(f.toURI().toString());
            picture.setImage(pic);
            counter--;
        }
    }

    @FXML
    protected void onReadBtnClick() {
        startBtn.setText("Início - LEITURA");
        example = "leitura";
        File f = new File("src/main/resources/com/example/aop/img/"  + example + "/Frame 1.png");
        Image pic = new Image(f.toURI().toString());
        picture.setImage(pic);
        counter = 1;
    }

    @FXML
    protected void onArithmeticsBtnClick() {
        startBtn.setText("Início - ARITMÉTICA");
        example = "aritmetica";
        File f = new File("src/main/resources/com/example/aop/img/"  + example + "/Frame 1.png");
        Image pic = new Image(f.toURI().toString());
        picture.setImage(pic);
        counter = 1;
    }

    @FXML
    protected void onWriteBtnClick() {
        startBtn.setText("Início - GRAVAÇÃO");
        example = "gravacao";
        File f = new File("src/main/resources/com/example/aop/img/"  + example + "/Frame 1.png");
        Image pic = new Image(f.toURI().toString());
        picture.setImage(pic);
        counter = 1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File f = new File("src/main/resources/com/example/aop/img/"  + example + "/Frame 1.png");
        Image pic = new Image(f.toURI().toString());
        picture.setImage(pic);
    }
}