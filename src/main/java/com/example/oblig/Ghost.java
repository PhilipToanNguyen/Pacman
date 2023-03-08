package com.example.oblig;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
        //movement(GhostOrange);

    }

    private Shape movement(Rectangle monster) throws InterruptedException {

        while (alive) {

            Thread.sleep(500);
            int i = (int) (Math.random() * 4 + 1);

            if (i == 1) {
                monster.setLayoutX(monster.getLayoutY() + 6.0);
                System.out.println("Right");
            } else if (i == 2) {
                monster.setLayoutX(monster.getLayoutX() - 6.0);
                System.out.println("Left");
            } else if (i == 3) {
                monster.setLayoutY(monster.getLayoutY() + 6.0);
                System.out.println("Down");
            } else if (i == 4) {
                monster.setLayoutY(monster.getLayoutY() - 6.0);
                System.out.println("Up");
            } else {
                alive = false;
            }
        }
        return monster;

    }
}



