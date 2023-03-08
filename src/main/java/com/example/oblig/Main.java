package com.example.oblig;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static javafx.scene.paint.Color.BLACK;


public class Main extends Application {

    public static Scene scene;
    public static Pane pane;

    //Score info
    Label currentScoreLabel;
    public int currentScore;

    // SOUND
    Sound music = new Sound();
    Sound se = new Sound();

    //SCREEN SETTINGS
    public static final int screenWidth = 840;
    public static final int screenHeight = 900;




    public void start(Stage primaryStage) throws IOException, InterruptedException {

        pane = new Pane();
        scene = new Scene(pane, screenWidth, screenHeight);

        //Score
        currentScoreLabel = new Label("Current Score: " + Integer.toString(currentScore));
        currentScoreLabel.setPrefWidth(150);
        currentScoreLabel.setFont(Font.font("Comic Sans MS", 18));
        currentScoreLabel.setStyle("-fx-text-fill: Yellow;");
        VBox score = new VBox(currentScoreLabel);
        score.setLayoutX(screenWidth/2 - 70);
        score.setLayoutY(screenHeight/2);

        //Legg til Map
        Map kart = new Map();
        //PLAYER
        PacMan player = new PacMan();
        //GHOST
        Ghost ghost = new Ghost();


        AnimationTimer collisionTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                player.controller();
                kart.matForPacMan(player.pacman);
                kart.checkCollision(player.pacman);


            }

        };
        collisionTimer.start();
        pane.setStyle("-fx-background-color : black");
        pane.setPrefSize(screenWidth, screenHeight);





        //Legg til
        pane.getChildren().add(player.pacman); //PACMAN
        pane.getChildren().addAll(ghost.GhostRed, ghost.GhostBlue, ghost.GhostPink, ghost.GhostOrange);        //ENEMIES
        pane.getChildren().add(score);  //SCORE



        primaryStage.setResizable(false);
        primaryStage.setTitle("PacMan 2022");

        primaryStage.setScene(scene);
        primaryStage.show();
        //////////////////

    }

    public static void main(String[] args) {
        launch();
    }

}