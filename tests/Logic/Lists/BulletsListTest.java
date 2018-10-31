package Logic.Lists;

import Game.Attack;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulletsListTest {

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Test
    void addBullet() {
        BulletsList.reset();
        BulletsList bulletsList = BulletsList.getInstance();
        assertEquals(0, bulletsList.getLarge());
        bulletsList.addBullet(new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet"));
        assertEquals(1, bulletsList.getLarge());
        bulletsList.addBullet(new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet"));
        assertEquals(2, bulletsList.getLarge());
        bulletsList.addBullet(new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet"));
        assertEquals(3, bulletsList.getLarge());
    }

    @Test
    void deleteBullet() {
        BulletsList.reset();
        BulletsList bulletsList = BulletsList.getInstance();
        assertEquals(0, bulletsList.getLarge());
        Attack attack1 = new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
        bulletsList.addBullet(attack1);
        assertEquals(1, bulletsList.getLarge());
        bulletsList.deleteBullet(attack1);
        assertEquals(0, bulletsList.getLarge());
        bulletsList.addBullet(attack1);
        Attack attack2 = new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
        Attack attack3 = new Attack(0, 0, 12, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
        bulletsList.addBullet(attack2);
        bulletsList.addBullet(attack3);
        assertEquals(3, bulletsList.getLarge());
        bulletsList.deleteBullet(attack3);
        assertEquals(2, bulletsList.getLarge());
        bulletsList.addBullet(attack3);
        bulletsList.deleteBullet(attack2);
        assertEquals(2, bulletsList.getLarge());
    }
}