package com.example.oblig;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static com.example.oblig.Ghost.*;

public class Main extends Application {
    /**
     Scene og pane
     */
    public static Scene scene;
    public static Pane pane;

    /**
     Score info
     */
   public static int currentScore = 0;
   public static int  life = 3;
    /**
   Skjermoppløsning
     */
    //SCREEN SETTINGS
    public static final int screenWidth = 840;
    public static final int screenHeight = 900;

    public void start(Stage primaryStage) {

        /**
         Oppretter
         */
        pane = new Pane();
        scene = new Scene(pane, screenWidth, screenHeight);

        /**
         Legger til map som kart
         */
        Map kart = new Map();

        /**
         Kaller ghost
         */
        Ghost ghost = new Ghost();
        Blue blue = new Blue(30 * 15, 30 * 13, 30, 30);

        /**
         Kaller spiller/pacman
         */
        PacMan player = new PacMan(30 * 14,15 * 45,12);


        /**
         * AnimationTimer blir brukt for oppdatering for bevegelser og collisions
         * fjerning av mat og energimat.
         * Legger vi f.eks matForPacMan utenfor AnimationTimer så vil ikke
         * PacMan kunne fjerne maten mer enn 1 gang.
         */
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

                // RØD OG ORANSJE KOLLISJON = NY RETNING
                kart.ghostCollideGhost(ghost.GhostOrange, ghost.GhostRed);
            }
        };
        animationTimer.start();

        /**
         Styling
         */
        pane.setStyle("-fx-background-color : black");
        pane.setPrefSize(screenWidth, screenHeight);

        /**
         Legg til Ghost og Pacman i pane
         */
        pane.getChildren().add(player.pacman); //PACMAN
        pane.getChildren().addAll(ghost.GhostRed, ghost.GhostPink, ghost.GhostOrange, ghost.GhostBlue);  //ENEMIES
        pane.getChildren().add(blue);

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