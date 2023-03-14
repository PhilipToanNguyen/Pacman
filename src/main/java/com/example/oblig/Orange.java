package com.example.oblig;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Orange extends Enemies  {
    Rectangle GhostOrange;
    public static int randomMovementOrange;

    public Orange() {
        this.GhostOrange = GhostOrange;
        GhostOrange = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostOrange.setFill(Color.ORANGE);

    }

    @Override
    public void GhostDirection(Node monster, int randomMovementBlue) {
        super.GhostDirection(GhostOrange, randomMovementBlue);
    }
}



