package Game;

import GUI.Holder;
import GUI.Game;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    Dragon dragon;

    {
        try {
            dragon = new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
        Holder.enemyRute = "file:src/Media/Enemies/Nightfury.gif";
    }

    @Test
    void moveLeft() {
        dragon.moveLeft();
        assertTrue(dragon.isDead());
        assertEquals(1, Game.lose);
    }

    @Test
    void moveToX() {
        dragon.setPosx(10);
        dragon.setTranslateX(5);
        dragon.moveToX();
        assertFalse(dragon.isReadyX());
        dragon.setPosx(5);
        dragon.setTranslateX(10);
        dragon.moveToX();
        assertFalse(dragon.isReadyX());
        dragon.setPosx(5);
        dragon.setTranslateX(5);
        dragon.moveToX();
        assertTrue(dragon.isReadyX());
    }

    @Test
    void moveToY() {
        dragon.setPosy(10);
        dragon.setTranslateY(5);
        dragon.moveToY();
        assertFalse(dragon.isReadyY());
        dragon.setPosy(5);
        dragon.setTranslateY(10);
        dragon.moveToY();
        assertFalse(dragon.isReadyY());
        dragon.setPosy(5);
        dragon.setTranslateY(5);
        dragon.moveToY();
        assertTrue(dragon.isReadyY());
    }
}