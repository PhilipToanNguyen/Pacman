package com.example.oblig;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import static com.example.oblig.Ghost.*;


public class Main extends Application {

    public static Scene scene;
    public static Pane pane;

    //Score info
   public static Text currentScoreText;
   public static int currentScore = 0;
   public static int  life = 3;

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

        //SCORE og STYLING
        currentScoreText = new Text("Score: " + currentScore);
        currentScoreText.setFont(Font.font("Comic Sans MS", 18));
        currentScoreText.setStyle("-fx-text-Informasjon og fyll: Yellow;");
        VBox score = new VBox(currentScoreText);
        score.setLayoutX(screenWidth/2 - 30);
        score.setLayoutY(screenHeight/2);

        //Animation // FPS
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                //MAT OG VEGG COLLISION
                kart.checkCollision(player.pacman);
                kart.matForPacMan(player.pacman);
                kart.energi(player.pacman);

                // BEVEGELSE FOR SPILLER
                player.controller();
                //GAMEOVER // KOLLISJON mellom spiller og ghost
                kart.playerCollideGhost(player.pacman, ghost.GhostOrange);
                kart.playerCollideGhost(player.pacman, ghost.GhostPink);
                kart.playerCollideGhost(player.pacman, ghost.GhostRed);
                kart.playerCollideGhost(player.pacman, ghost.GhostBlue);

                //BEVEGELSE I DET DE KOLLIDERER
                //ORANSJE
                kart.checkCollisionGhostOrange(ghost.GhostOrange);
                ghost.GhostDirection(ghost.GhostOrange, randomMovementOrange);
                //BLÅ
                kart.checkCollisionGhostBlue(ghost.GhostBlue);
                ghost.GhostDirection(ghost.GhostBlue, randomMovementBlue);
                //RØD
                kart.checkCollisionGhostRed(ghost.GhostRed);
                ghost.GhostDirection(ghost.GhostRed, randomMovementRed);
                //ROSA
                kart.checkCollisionGhostPink(ghost.GhostPink);
                ghost.GhostDirection(ghost.GhostPink, randomMovementPink);
            }
        };
        animationTimer.start();

        //Styling
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