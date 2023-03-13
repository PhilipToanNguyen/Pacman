package com.example.oblig;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
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
   public static Text currentScoreText;
   public static int currentScore = 0;
   public static int  life = 3;

    // SOUND
    Sound music = new Sound();
    Sound se = new Sound();

    //SCREEN SETTINGS
    public static final int screenWidth = 840;
    public static final int screenHeight = 900;


    public void start(Stage primaryStage) throws IOException, InterruptedException {
        //Oppretter
        pane = new Pane();
        scene = new Scene(pane, screenWidth, screenHeight);

        //Legg til Map
        Map kart = new Map();

        //Kaller GHOST
        Ghost ghost = new Ghost();

        //Kaller PLAYER
        PacMan player = new PacMan();

        //SCORE
        currentScoreText = new Text("Score: " + currentScore);
        currentScoreText.setFont(Font.font("Comic Sans MS", 18));
        currentScoreText.setStyle("-fx-text-fill: Yellow;");
        VBox score = new VBox(currentScoreText);
        score.setLayoutX(screenWidth/2 - 30);
        score.setLayoutY(screenHeight/2);

        //Animation // FPS
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //GAMEOVER // KOLLISJON mellom spiller og ghost
                kart.playerCollideGhost(player.pacman, ghost.GhostOrange);
                kart.playerCollideGhost(player.pacman, ghost.GhostPink);
                kart.playerCollideGhost(player.pacman, ghost.GhostRed);
                kart.playerCollideGhost(player.pacman, ghost.GhostBlue);

                //COLLISION og BEVEGELSE I DET DE KOLLIDERER
                kart.checkCollision(player.pacman);
                kart.checkCollisionGhost(ghost.GhostOrange);
                kart.checkCollisionGhost(ghost.GhostBlue);
                kart.checkCollisionGhost(ghost.GhostRed);
                kart.checkCollisionGhost(ghost.GhostPink);
                //MAT
                kart.matForPacMan(player.pacman);
                // BEVEGELSE
                player.controller();
                // START BEVEGELSE SLIK AT DE GÅR UT AV BOKSEN
                ghost.move(ghost.GhostOrange);
                ghost.move(ghost.GhostPink);
                ghost.move(ghost.GhostRed);
                ghost.move(ghost.GhostBlue);

            }

        };
        animationTimer.start();

        pane.setStyle("-fx-background-color : black");
        pane.setPrefSize(screenWidth, screenHeight);

        //Legg til
        pane.getChildren().add(player.pacman); //PACMAN
        pane.getChildren().addAll(ghost.GhostRed, ghost.GhostPink, ghost.GhostOrange, ghost.GhostBlue);  //ENEMIES

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