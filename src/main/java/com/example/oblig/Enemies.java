package com.example.oblig;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.example.oblig.PacMan.alive;

// Abstract class
abstract class Enemies {
    // Abstract method (does not have a body)
    public abstract void Movement() throws InterruptedException;

    // Regular method
    public void Body(int x, int y, int b, int h, Color c) {
        // The body of animalSound() is provided here
        Rectangle Body = new Rectangle(x,y,b,h);
        Body.setFill(c);
    }



}
