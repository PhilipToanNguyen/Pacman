package com.example.oblig;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Red extends Enemies  {
    Rectangle GhostRed;
    public static int randomMovementRed;

    public Red() {
        this.GhostRed = GhostRed;
        GhostRed = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostRed.setFill(Color.RED);

    }

    @Override
    public void GhostDirection(Node monster, int randomMovementBlue) {
        super.GhostDirection(GhostRed, randomMovementBlue);
    }
}


