package Game;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {

    private Attack enemybullet = new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
    private Attack playerbullet = new Attack(0, 900, 12, 40, 40, "file:src/Media/Bullets/Green Bullet.png", "playerbullet");

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Test
    void moveRight() {
        playerbullet.moveRight();
        assertTrue(playerbullet.isDead());
        playerbullet.setPosx(0);
        playerbullet.moveRight();
        assertEquals(5, playerbullet.getTranslateX());
        assertEquals(5, playerbullet.getPosx());
    }

    @Test
    void moveLeft() {
        enemybullet.moveLeft();
        assertTrue(enemybullet.isDead());
        enemybullet.setPosx(2);
        enemybullet.moveLeft();
        assertEquals(0, enemybullet.getTranslateX());
        assertEquals(0, enemybullet.getPosx());
    }
}