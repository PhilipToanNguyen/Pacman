package com.example.oblig;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class Ghost {
    Rectangle GhostRed;
    Rectangle GhostBlue;
    Rectangle GhostPink;
    Rectangle GhostOrange;
    public static int randomMovementOrange;
    public static int randomMovementRed;
    public static int randomMovementBlue;
    public static int randomMovementPink;

    public Ghost()  {
        this.GhostRed = GhostRed;
        this.GhostBlue = GhostBlue;
        this.GhostPink = GhostPink;
        this.GhostOrange = GhostOrange;

        /**
         * Lager Ghost med x-posisjon, y-posisjon, bredde, høyde
         */

        /**
         * Lager Red
         */
        GhostRed = new Rectangle(30 * 14, 30 * 13, 30, 30);
        GhostRed.setFill(Color.RED);

        /**
         * Lager Blue
         */
        GhostBlue = new Rectangle(30 * 15, 30 * 13, 30, 30);
        GhostBlue.setFill(Color.CYAN);

        /**
         * Lager Pink
         */
        GhostPink = new Rectangle(30 * 12, 30 * 13, 30, 30);
        GhostPink.setFill(Color.PINK);

        /**
         * Lager Orange
         */
        GhostOrange = new Rectangle(30 * 13, 30 * 13, 30, 30);
        GhostOrange.setFill(Color.ORANGE);

    }
    /**
     * Denne metoden brukes for å bestemme retningen som ghosten skal automatisk gå i.
     * Denne metoden henger sammen med checkCollisionGhostFarge(Oransje, Rød, Blå og Rosa)
     * @param monster er Ghost.
     * @param retning er variabel med math.random som gir heltall.
     * Ved bruk av math.random skal det velges tilfeldig et av casene (0-3)
     */
    public void GhostDirection(Node monster, int retning) {
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











