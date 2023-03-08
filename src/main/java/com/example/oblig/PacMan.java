package com.example.oblig;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;


public class PacMan {

    public static boolean alive = true;
    Circle pacman;
    int x = 30;
    int y = 30;

    public PacMan() {
        this.pacman = pacman;
        pacMan();
    }

    public void pacMan() {
        pacman = new Circle(30*14,15*45,12);
        pacman.setFill(Color.YELLOW);
        controller();
    }

    public void controller() {
        Main.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                TranslateTransition translate = new TranslateTransition(Duration.millis(30), pacman);

                if (event.getCode() == KeyCode.D) {
                    translate.setByX(+3);
                    translate.play();
                    //System.out.println(pacman.getTranslateX());
                } else if (event.getCode() == KeyCode.A) {
                    translate.setByX(-3);
                    translate.play();
                    //System.out.println(pacman.getTranslateX());
                } else if (event.getCode() == KeyCode.S) {
                    translate.setByY(+3);
                    translate.play();
                    // System.out.println(pacman.getTranslateY());
                } else if (event.getCode() == KeyCode.W) {
                    translate.setByY(-3);
                    translate.play();
                    //System.out.println(pacman.getTranslateY());
                }
            }


        });
    }

    /*public void controller() {
        Main.scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){

                if (event.getCode() == KeyCode.RIGHT) {
                    pacman.setLayoutX(pacman.getLayoutX() + 6.0);
                    System.out.println(pacman.getTranslateX());
                }
                else if (event.getCode() == KeyCode.LEFT) {
                    pacman.setLayoutX(pacman.getLayoutX() - 6.0);
                    System.out.println(pacman.getTranslateX());
                }
                else if (event.getCode() == KeyCode.DOWN) {
                    pacman.setLayoutY(pacman.getLayoutY() + 6.0);
                    System.out.println(pacman.getTranslateY());
                }
                else if (event.getCode() == KeyCode.UP) {
                    pacman.setLayoutY(pacman.getLayoutY() - 6.0);
                    System.out.println(pacman.getTranslateY());
                }
            }


        });

     */
    }




