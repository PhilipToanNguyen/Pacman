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
    public static int randomMovementOrange;
    public static int randomMovementRed;
    public static int randomMovementBlue;
    public static int randomMovementPink;
    public static Rectangle vegg;
    public static ArrayList<Node> food = new ArrayList<Node>();
    public static ArrayList<Node> food2 = new ArrayList<Node>();
    public static ArrayList<Node> wall = new ArrayList<Node>();


    //Hvordan mappen ser ut
    int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 4, 4, 4, 4, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 0},
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
                if (map[i][j] == 5) {
                    Circle energi = new Circle(j * x, i * y, 6);
                    energi.setLayoutY(y / 2);
                    energi.setLayoutX(x / 2);
                    energi.setFill(Color.YELLOW);
                    FadeTransition fade = new FadeTransition(Duration.seconds(1), energi);
                    fade.setToValue(0.1);
                    fade.setCycleCount(Animation.INDEFINITE);
                    fade.play();
                    pane.getChildren().add(energi);
                    food2.add(energi);

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

                     System.out.println("Kræsj LEFT");
                }
                //RIGHT
                if (p.getTranslateX() > vegg.getTranslateX()) {
                    p.setTranslateX(p.getTranslateX() - 3);
                    System.out.println("Kræsj RIGHT");
                }
                //DOWN
                if (p.getTranslateY() > vegg.getTranslateY()) {
                    p.setTranslateY(p.getTranslateY() - 3);
                    System.out.println("Kræsj DOWN");
                }
                //UP
                if (p.getTranslateY() < vegg.getTranslateY()) {
                    p.setTranslateY(p.getTranslateY() + 3);
                     System.out.println("Kræsj UP");
                }
            }
        }
    }

    // Metode, Mat eller pellets for Pacman.
    // "Pacman spiser opp maten". og poeng telles opp. ved kollidering
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
            for (Node pellets : food2) {
                if (p.getBoundsInParent().intersects(pellets.getBoundsInParent())) {
                    food2.remove(pellets);
                    pane.getChildren().remove(pellets);
                    int i = currentScore + 100;
                    System.out.println("Score: " + currentScore);
                }
            }

        } catch (Exception e) {


        }
    }

    //Energi mat for pacman som gjør mulig for spilleren å ta spøkelsene i en liten periode
    public void energi(Node p) {
        try {
            for (Node pellets : food2) {
                if (p.getBoundsInParent().intersects(pellets.getBoundsInParent())) {
                    food2.remove(pellets);
                    pane.getChildren().remove(pellets);
                }
            }

        } catch (Exception e) {


        }
    }

    //Metode for kollisjon mellom spiller og ghost, slik at spilleren må unngå ghost.
    //Metoden inneholder også antall liv og reduserer ved kollidering og respawn av spiller med UI
    public void playerCollideGhost(Node player, Node monster) {
        Text tekst = new Text(-60, 20, "Antall liv:" + life);
        tekst.setFont(Font.font("Verdana", 32));
        tekst.setFill(Color.YELLOW);
        tekst.setLayoutX(screenWidth / 2 - 30);
        tekst.setLayoutY(screenHeight / 2);
        if (player.getBoundsInParent().intersects(monster.getBoundsInParent())) {
            life--;
            player.setTranslateX(0);
            player.setTranslateY(0);
            System.out.println("Antall Liv: " + life);

            if (life == 0) {
                Text text = new Text(-60, 10, "Gameover");
                Text text2 = new Text(-80, 10, "Total score: " + currentScore);
                text.setFont(Font.font("Verdana", 24));
                text.setFill(Color.YELLOW);
                text2.setFont(Font.font("Verdana", 14));
                text2.setFill(Color.RED);
                VBox loseinfo = new VBox(text, text2);
                player.setVisible(false);
                loseinfo.setLayoutX(screenWidth / 2 - 30);
                loseinfo.setLayoutY(screenHeight / 2);
                pane.getChildren().add(loseinfo);
            }
        }
    }

    //Metode for veggkollisjon for oransje ghost.
    // Ved kollisjon er det meningen de skal gå en annen retning som ikke kolliderer
    public void checkCollisionGhostOrange(Node monster) {
        for (Node vegg : wall) {

            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                //LEFT COLLISION
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() - 1);
                    randomMovementOrange = (int) (Math.random() * 4);
                    if(randomMovementOrange == 0) {
                        randomMovementOrange = (int) (Math.random() * 4);
                    }
                }
                //DOWN COLLISION
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() - 1);
                    if(randomMovementOrange == 1) {
                        randomMovementOrange = (int) (Math.random() * 4);
                    }
                }
                //UP COLLISION
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() + 1);
                    if(randomMovementOrange == 2) {
                        randomMovementOrange = (int) (Math.random() * 4);
                    }
                }
                //RIGHT COLLISION
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() + 1);
                    if(randomMovementOrange == 3) {
                        randomMovementOrange = (int) (Math.random() * 4);
                    }
                }
            }
        }
    }
    //Metode for veggkollisjon for oransje ghost.
    // Ved kollisjon er det meningen de skal gå en annen retning som ikke kolliderer
    public void checkCollisionGhostRed(Node monster) {
        for (Node vegg : wall) {

            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                //LEFT COLLISION
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() - 1);
                    randomMovementRed = (int) (Math.random() * 4);
                    if(randomMovementRed == 0) {
                        randomMovementRed = (int) (Math.random() * 4);
                    }
                }
                //DOWN COLLISION
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() - 1);
                    if(randomMovementRed == 1) {
                        randomMovementRed = (int) (Math.random() * 4);
                    }
                }
                //UP COLLISION
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() + 1);
                    if(randomMovementRed == 2) {
                        randomMovementRed = (int) (Math.random() * 4);
                    }
                }
                //RIGHT COLLISION
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() + 1);
                    if(randomMovementRed == 3) {
                        randomMovementRed = (int) (Math.random() * 4);
                    }
                }
            }
        }
    }
    //Metode for veggkollisjon for oransje ghost.
    // Ved kollisjon er det meningen de skal gå en annen retning som ikke kolliderer
    public void checkCollisionGhostBlue(Node monster) {
        for (Node vegg : wall) {

            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                //LEFT COLLISION
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() - 1);
                    randomMovementBlue = (int) (Math.random() * 4);
                    if(randomMovementBlue == 0) {
                        randomMovementBlue = (int) (Math.random() * 4);
                    }
                }
                //DOWN COLLISION
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() - 1);
                    if(randomMovementBlue == 1) {
                        randomMovementBlue = (int) (Math.random() * 4);
                    }
                }
                //UP COLLISION
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() + 1);
                    if(randomMovementBlue == 2) {
                        randomMovementBlue = (int) (Math.random() * 4);
                    }
                }
                //RIGHT COLLISION
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() + 1);
                    if(randomMovementBlue == 3) {
                        randomMovementBlue = (int) (Math.random() * 4);
                    }
                }
            }
        }
    }
    //Metode for veggkollisjon for oransje ghost.
    // Ved kollisjon er det meningen de skal gå en annen retning som ikke kolliderer
    public void checkCollisionGhostPink(Node monster) {
        for (Node vegg : wall) {

            if (monster.getBoundsInParent().intersects(vegg.getBoundsInParent())) {
                //LEFT COLLISION
                if (monster.getTranslateX() < vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() - 1);
                    randomMovementPink = (int) (Math.random() * 4);
                    if(randomMovementPink == 0) {
                        randomMovementPink = (int) (Math.random() * 4);
                    }
                }
                //DOWN COLLISION
                if (monster.getTranslateY() > vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() - 1);
                    if(randomMovementPink == 1) {
                        randomMovementPink = (int) (Math.random() * 4);
                    }
                }
                //UP COLLISION
                if (monster.getTranslateY() < vegg.getTranslateY()) {
                    monster.setTranslateY(monster.getTranslateY() + 1);
                    if(randomMovementPink == 2) {
                        randomMovementPink = (int) (Math.random() * 4);
                    }
                }
                //RIGHT COLLISION
                if (monster.getTranslateX() > vegg.getTranslateX()) {
                    monster.setTranslateX(monster.getTranslateX() + 1);
                    if(randomMovementPink == 3) {
                        randomMovementPink = (int) (Math.random() * 4);
                    }
                }
            }
        }
    }

    //Denne metoden brukes for å bestemme retningen som ghosten skal automatisk gå i.
    //Denne metoden henger sammen med checkCollisionGhostFarge(Oransje, Rød, Blå og Rosa)
    public void GhostDirection(Node monster, int retning) {
        switch (retning) {
            case 0:
                monster.setTranslateX(monster.getTranslateX() - 1);break;
            case 1:
                monster.setTranslateY(monster.getTranslateY() - 1);break;
            case 2:
                monster.setTranslateY(monster.getTranslateY() + 1);break;
            case 3:
                monster.setTranslateX(monster.getTranslateX() + 1);break;
        }
    }
}
    






