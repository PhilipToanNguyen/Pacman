package com.example.oblig;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.Random;

import static com.example.oblig.PacMan.alive;

public class Ghost {
    Rectangle GhostRed;
    Rectangle GhostBlue;
    Rectangle GhostPink;
    Rectangle GhostOrange;

    public Ghost() throws InterruptedException {
        this.GhostRed = GhostRed;
        this.GhostBlue = GhostBlue;
        this.GhostPink = GhostPink;
        this.GhostOrange = GhostOrange;
        //RED
        GhostRed = new Rectangle(30 * 14, 30 * 13, 30, 30);
        GhostRed.setFill(Color.RED);
        // movement(GhostRed);
        //BLUE
        GhostBlue = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostBlue.setFill(Color.CYAN);
        // movement(GhostBlue);
        //PINK
        GhostPink = new Rectangle(30 * 12, 30 * 13, 30, 30);
        GhostPink.setFill(Color.PINK);
        //movement(GhostPink);
        //ORANGE
        GhostOrange = new Rectangle(30 * 13, 30 * 13, 30, 30);
        GhostOrange.setFill(Color.ORANGE);
        movement(GhostOrange);

    }
    /*
     public Rectangle movement(Node monster) throws InterruptedException {
        TranslateTransition translate = new TranslateTransition(Duration.millis(30), monster);

        while (alive) {
            Thread.sleep(500);
            int i = (int) (Math.random() * 4 + 1);

            if (i == 1) {
                translate.setByX(6);
                translate.play();
                System.out.println("Right");

            } else if (i == 2) {
                translate.setByX(-6);
                translate.play();
                System.out.println("Left");
            } else if (i == 3) {
                translate.setByY(+6);
                translate.play();
                System.out.println("Down");
            } else if (i == 4) {
                translate.setByY(-6);
                translate.play();
                System.out.println("Up");
            } else {
                alive = false;
            }
        }
        return (Rectangle) monster;
    }
      */

    public void movement(Rectangle monster) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        int randomMovement = (int) (Math.random() * 4);

        if (randomMovement == 0) {
               final KeyValue opp = new KeyValue(monster.translateXProperty(), +30);
               final KeyFrame up = new KeyFrame(Duration.millis(1000), opp);
               timeline.getKeyFrames().add(up);
               timeline.play();
           } else if (randomMovement == 1) {
               final KeyValue ned = new KeyValue(monster.translateYProperty(), -30);
               final KeyFrame down = new KeyFrame(Duration.millis(1000), ned);
               timeline.getKeyFrames().add(down);
               timeline.play();
           } else if (randomMovement == 2) {
               final KeyValue venstre = new KeyValue(monster.translateXProperty(), -30);
               final KeyFrame left = new KeyFrame(Duration.millis(1000), venstre);
               timeline.getKeyFrames().add(left);
               timeline.play();
           } else if (randomMovement == 3) {
               final KeyValue hoyre = new KeyValue(monster.translateXProperty(), +30);
               final KeyFrame right = new KeyFrame(Duration.millis(1000), hoyre);
               timeline.getKeyFrames().add(right);

               timeline.play();
           }
       }
    }





