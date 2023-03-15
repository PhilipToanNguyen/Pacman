package com.example.oblig;

import javafx.scene.shape.Rectangle;

/**
 Parent-class med extended Rectangle
 for Red, Blue, Pink og Orange class
 */
public class Enemies extends Rectangle{
    int posisjonx;
    int posisjony;
    int bredde;
    int hoyde;

    /**
     * Konstruktør med parametere for en rectangle/Ghost
     */
    public Enemies(int posisjonx, int posisjony, int bredde, int hoyde) {
        this.posisjonx = posisjonx;
        this.posisjony = posisjony;
        this.bredde = bredde;
        this.hoyde = hoyde;

        }

    }


