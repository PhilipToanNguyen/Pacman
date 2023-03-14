package com.example.oblig;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.Random;


public class Ghost {
    Rectangle GhostRed;
    Rectangle GhostBlue;
    Rectangle GhostPink;
    Rectangle GhostOrange;

    //Konstruktør
    public Ghost()  {
        this.GhostRed = GhostRed;
        this.GhostBlue = GhostBlue;
        this.GhostPink = GhostPink;
        this.GhostOrange = GhostOrange;

        //Lager ghost
        //x-posisjon, y-posisjon, bredde, høyde
        //Lager RED
        GhostRed = new Rectangle(30 * 14, 30 * 13, 30, 30);
        GhostRed.setFill(Color.RED);
        //Lager BLUE
        GhostBlue = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostBlue.setFill(Color.CYAN);

        //Lager PINK
        GhostPink = new Rectangle(30 * 12, 30 * 13, 30, 30);
        GhostPink.setFill(Color.PINK);

        //Lager ORANGE
        GhostOrange = new Rectangle(30 * 13, 30 * 13, 30, 30);
        GhostOrange.setFill(Color.ORANGE);

    }
    //Første bevegelsen for Ghost
    // for å komme seg ut av basen til kollidering
    // etter kollidering skal de "kunne" bevege av seg selv og velge en vei etter
    // kollidering ved hjelp av en annen metode i Map-klassen
    public void firstMove(Node monster) {
    TranslateTransition translate = new TranslateTransition(Duration.millis(100), monster);
    translate.setByY(-15);
    translate.play();
    }
}











