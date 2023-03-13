package com.example.oblig;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;

import static com.example.oblig.Main.*;

public class Map {

    int x = 30;
    int y = 30;
    int count = 0;

    public static Rectangle vegg;
    public static ArrayList<Node> food = new ArrayList<Node>();
    public static ArrayList<Node> wall = new ArrayList<Node>();


    //Hvordan mappen ser ut
    int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 4, 4, 4, 4, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //Konstruktør
    public Map() {
        this.map = map;
        loadMap();


    }
    //Metode for å laste opp Map. Denne metoden kalles under konstruktøren.
    public void loadMap() {
        //For-looper, plassering av vegg, vei og mat
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    vegg = new Rectangle(j * x, i * y, x, y);
                    vegg.setFill(Color.DARKBLUE);
                    pane.getChildren().add(vegg);
                    wall.add(vegg);
                }
                if (map[i][j] == 1) {
                    count++;
                    Circle mat = new Circle(j * x, i * y, 3);
                    mat.setLayoutY(y / 2);
                    mat.setLayoutX(x / 2);
                    mat.setFill(Color.DARKGOLDENROD);
                    pane.getChildren().add(mat);
                    food.add(mat);
                    //System.out.println(count);

                }
                if (map[i][j] == 3) {
                    Rectangle svei = new Rectangle(j * x, i * y, x, y);
                    svei.setFill(Color.DARKSLATEGRAY);
                    pane.getChildren().add(svei);
                }
                if (map[i][j] == 4) {
                    Rectangle vegg2 = new Rectangle(j * x, i * y, x, y);
                    vegg2.setFill(Color.DARKRED);
                    pane.getChildren().add(vegg2);
                }
            }
        }
    }

    //Metode for kollisjon mellom spiller og vegg. Ment for at spilleren ikke skal gå igjennom veggen
    public void checkCollision(Node p) {
        for (Node vegg : wall) {
            if (p.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                // System.out.println("kræsj");
                //LEFT
                if (p.getTranslateX() < vegg.getTranslateX()) {
                    p.setTranslateX(p.getTranslateX() + 3);

                    // System.out.println("Kræsj LEFT");
                }
                //RIGHT
                if (p.getTranslateX() > vegg.getTranslateX()) {
                    p.setTranslateX(p.getTranslateX() - 3);
                    // System.out.println("Kræsj RIGHT");
                }
                //DOWN
                if (p.getTranslateY() > vegg.getTranslateY()) {
                    p.setTranslateY(p.getTranslateY() - 3);
                    //System.out.println("Kræsj DOWN");
                }
                //UP
                if (p.getTranslateY() < vegg.getTranslateY()) {
                    p.setTranslateY(p.getTranslateY() + 3);
                    // System.out.println("Kræsj UP");
                }
            }
        }
    }

    // Metode, Mat eller pellets for Pacman.
    // "Pacman spiser opp maten". og poeng telles opp.
    public void matForPacMan(Node p) {
        try {
            for (Node pellets : food) {
                if (p.getBoundsInParent().intersects(pellets.getBoundsInParent())) {
                    food.remove(pellets);
                    pane.getChildren().remove(pellets);
                    int i = currentScore++;
                    System.out.println("Score: " + currentScore);

                }
            }
        } catch (Exception e) {


        }
    }

    //Metode for veggkollisjon for ghost.
    // Ved kollisjon er det meningen de skal gå en annen retning som ikke kolliderer
    public void checkCollisionGhost(Node monster) {
        for (Node vegg : wall) {
            Timeline timeline = new Timeline();
            TranslateTransition translate = new TranslateTransition(Duration.millis(200), monster);

            int randomMovement = (int) (Math.random() * 4);
            //MOVEMENTS
            final KeyValue opp = new KeyValue(monster.translateYProperty(), -30);
            final KeyFrame up = new KeyFrame(Duration.millis(300), opp);
            final KeyValue ned = new KeyValue(monster.translateYProperty(), +30);
            final KeyFrame down = new KeyFrame(Duration.millis(300), ned);
            final KeyValue venstre = new KeyValue(monster.translateXProperty(), -30);
            final KeyFrame left = new KeyFrame(Duration.millis(300), venstre);
            final KeyValue hoyre = new KeyValue(monster.translateXProperty(), +30);
            final KeyFrame right = new KeyFrame(Duration.millis(300), hoyre);


            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {

                //LEFT COLLISION
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() + 0.5);
                    translate.setByY(-30);
                    translate.play();

                }
                //RIGHT COLLISION
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() - 0.5);
                    translate.setByY(30);
                    translate.play();

                }
                //DOWN COLLISION
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() - 0.5);
                    translate.setByX(-30);
                    translate.play();

                }
                //UP COLLISION
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() + 0.5);
                    translate.setByX(30);
                    translate.play();
                }

            }
        }
    }

    //Metode for kollisjon mellom spiller og ghost, slik at spilleren må unngå ghost.
    public void playerCollideGhost(Node player, Node monster) {
        int i = life;

        if (player.getBoundsInParent().intersects(monster.getBoundsInParent())) {
                life--;
                player.setTranslateX(0);
                player.setTranslateY(0);
            System.out.println(life);


                if (life == 0 ) {
                    Text text = new Text();
                    text.setText("Gameover");
                    text.setFont(Font.font ("Verdana", 24));
                    text.setFill(Color.YELLOW);
                    VBox loseinfo = new VBox(text);
                    player.setVisible(false);
                    loseinfo.setLayoutX(screenWidth/2 - 30);
                    loseinfo.setLayoutY(screenHeight/2);
                    pane.getChildren().add(loseinfo);
                }
            }
        }

}





    /*
public void matForPacMan(Node p) {
    for (int i = food.size()-1; i >= 0 ; i--) {

        if (p.getBoundsInParent().intersects(food.get(i).getBoundsInParent())) {
            food.remove(food.get(i));
            pane.getChildren().remove(food.get(i));
            //System.out.println(food.get(i));

        }
    }
}

    /*
    public void move(Node monster) {
        for (Node vegg : wall) {
            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                // System.out.println("kræsj");
                //LEFT
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    final KeyValue venstre = new KeyValue(monster.translateXProperty(), -30);
                    final KeyFrame left = new KeyFrame(Duration.millis(1000), venstre);
                    timeline.getKeyFrames().add(left);
                    timeline.play();
                    // System.out.println("Kræsj LEFT");

                }
                //RIGHT
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    final KeyValue hoyre = new KeyValue(monster.translateXProperty(), +30);
                    final KeyFrame right = new KeyFrame(Duration.millis(1000), hoyre);
                    timeline.getKeyFrames().add(right);
                    timeline.play();
                    // System.out.println("Kræsj RIGHT");
                }
                //DOWN
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    final KeyValue ned = new KeyValue(monster.translateYProperty(), +30);
                    final KeyFrame down = new KeyFrame(Duration.millis(1000), ned);
                    timeline.getKeyFrames().add(down);
                    timeline.play();
                    //System.out.println("Kræsj DOWN");
                }
                //UP
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    final KeyValue opp = new KeyValue(monster.translateYProperty(), -30);
                    final KeyFrame up = new KeyFrame(Duration.millis(1000), opp);
                    timeline.getKeyFrames().add(up);
                    timeline.play();
                    // System.out.println("Kræsj UP");
                }
            }
*/


