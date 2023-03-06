package com.example.oblig;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Hei {
    //Score info
    private Label currentScoreLabel, highScoreLabel;
    private int currentScore, highScore;

    public void start(Stage stage) throws IOException {
        Stage window = stage;
        Pane pane = new Pane();
        pane.setPrefSize(300, 300);
        pane.setStyle("-fx-background-color : black"); //Setter sort bakgrunn

        currentScoreLabel = new Label("Current Score: " + Integer.toString(currentScore));
        currentScoreLabel.setPrefWidth(150);
        currentScoreLabel.setFont(Font.font("Comic Sans MS", 18));
        highScoreLabel = new Label("High Score: " + Integer.toString(highScore));
        highScoreLabel.setFont(Font.font("Comic Sans MS", 18));
        highScoreLabel.setPrefWidth(150);



        Button btUp = new Button("UP");
        Button btDown = new Button("DOWN");
        Button btLeft = new Button("LEFT");
        Button btRight = new Button("RIGHT");


        HBox scoreinfo = new HBox(660, currentScoreLabel, highScoreLabel);
        scoreinfo.setStyle("-fx-background-color : yellow"); //Setter sort bakgrunn
        VBox vbox = new VBox(scoreinfo, pane);

    }
}
