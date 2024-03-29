package com.example.oblig;
import javafx.scene.Node;

import javafx.scene.paint.Color;

/**
 Sub-class med extended Enemies
 */
public class Blue extends Enemies  {
    public static int randomMovementBlue;

    /**
     * Konstruktør med parametere for en rectangle/Ghost
     */
    public Blue(int x, int y, int b, int h) {
        super(x, y, b, h);
        setFill(Color.BLUE);
    }

    /**
     * Denne metoden brukes for å bestemme retningen som ghosten skal automatisk gå i.
     * Denne metoden henger sammen med checkCollisionGhostFarge(Oransje, Rød, Blå og Rosa)
     * @param monster er Ghost.
     * @param retning er variabel med math.random som gir heltall.
     * Ved bruk av math.random skal det velges tilfeldig et av casene (0-3)
     */
    public void EnemyDirection(Node monster, int retning) {
        switch (retning) {
            case 0:
                monster.setTranslateX(monster.getTranslateX() - 0.3);break;
            case 1:
                monster.setTranslateY(monster.getTranslateY() - 0.3);break;
            case 2:
                monster.setTranslateY(monster.getTranslateY() + 0.3);break;
            case 3:
                monster.setTranslateX(monster.getTranslateX() + 0.3);break;
        }
    }


}



