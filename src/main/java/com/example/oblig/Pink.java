package com.example.oblig;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pink extends Enemies  {
    Rectangle GhostPink;
    public static int randomMovementPink;

    public Pink() {
        this.GhostPink = GhostPink;
        GhostPink = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostPink.setFill(Color.PINK);

    }

    @Override
    public void GhostDirection(Node monster, int randomMovementBlue) {
        super.GhostDirection(GhostPink, randomMovementBlue);
    }
}


