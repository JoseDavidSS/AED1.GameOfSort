package Game;

import GUI.Holder;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeastTest {

    Gryphon player = new Gryphon(9, 50, 50, 130, 80, Holder.playerRute);

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
        Holder.playerRute = "file:src/Media/Players/Charizard.gif";
    }

    @Test
    void moveUp() {
        player.setPosy(0);
        player.moveUp();
        assertEquals(0, player.getPosy());
        player.setPosy(100);
        player.moveUp();
        assertEquals(90, player.getPosy());
        assertEquals(90, player.getTranslateY());
    }

    @Test
    void moveDown() {
        player.setPosy(700);
        player.moveDown();
        assertEquals(700, player.getPosy());
        player.setPosy(100);
        player.moveDown();
        assertEquals(110, player.getPosy());
        assertEquals(110, player.getPosy());
    }

    @Test
    void moveLeft() {
        player.setPosx(0);
        player.moveLeft();
        assertEquals(0, player.getPosx());
        player.setPosx(100);
        player.moveLeft();
        assertEquals(90, player.getPosx());
        assertEquals(90, player.getTranslateX());
    }

    @Test
    void moveRight() {
        player.setPosx(830);
        player.moveRight();
        assertEquals(830, player.getPosx());
        player.setPosx(100);
        player.moveRight();
        assertEquals(110, player.getPosx());
        assertEquals(110, player.getTranslateX());
    }

    @Test
    void hit() {
        player.setResistence(0);
        player.hit();
        assertTrue(player.isDead());
        player.setResistence(1);
        player.hit();
        assertEquals(0, player.getResistence());
    }
}