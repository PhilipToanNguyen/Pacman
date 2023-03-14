package com.example.oblig;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Blue extends Enemies  {
    Rectangle GhostBlue;
    public static int randomMovementBlue;

    public Blue() {
        this.GhostBlue = GhostBlue;
        GhostBlue = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostBlue.setFill(Color.BLUE);

    }

    @Override
    public void GhostDirection(Node monster, int randomMovementBlue) {
        super.GhostDirection(GhostBlue, randomMovementBlue);
    }
}



