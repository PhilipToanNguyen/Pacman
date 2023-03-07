package com.example.oblig;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
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
        pacman = new Circle(30*14,15*45,12);
        pacman.setFill(Color.YELLOW);

        Main.scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){

                if (event.getCode() == KeyCode.RIGHT) {
                    TranslateTransition translate = new TranslateTransition(Duration.millis(50),pacman);
                    translate.setByX(6);
                    translate.play();
                }
                else if (event.getCode() == KeyCode.LEFT) {
                    TranslateTransition translate = new TranslateTransition(Duration.millis(50),pacman);
                    translate.setByX(-6);
                    translate.play();
                }
                else if (event.getCode() == KeyCode.DOWN) {
                    TranslateTransition translate = new TranslateTransition(Duration.millis(50),pacman);
                    translate.setByY(6);
                    translate.play();
                }
                else if (event.getCode() == KeyCode.UP) {
                    TranslateTransition translate = new TranslateTransition(Duration.millis(50),pacman);
                    translate.setByY(-6);
                    translate.play();
                }
            }

        });

    }
    }



