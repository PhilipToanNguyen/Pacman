package com.example.oblig;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.example.oblig.PacMan.alive;

public class Blue extends Enemies {
    Rectangle blue;
    public Blue () throws InterruptedException {
        this.blue = blue;
        Body(30 * 15, 30 * 13, 30, 30, Color.BLUE);
        //Movement();
    }

    public void Movement() throws InterruptedException {
        TranslateTransition translate = new TranslateTransition(Duration.millis(30),blue);
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
    }




}
