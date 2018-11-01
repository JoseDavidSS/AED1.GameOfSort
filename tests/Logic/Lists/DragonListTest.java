package Logic.Lists;

import GUI.Holder;
import Game.Dragon;
import Game.GameUtil;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DragonListTest {

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
        Holder.enemyRute = "file:src/Media/Enemies/Nightfury.gif";
    }

    @Test
    void addEnemy() throws IOException {
        DragonList.reset();
        DragonList dragonList = DragonList.getInstance();
        assertEquals(0, dragonList.getLarge());
        dragonList.addEnemy(new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 1));
        assertEquals(1, dragonList.getLarge());
        dragonList.addEnemy(new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 2));
        assertEquals(2, dragonList.getLarge());
        dragonList.addEnemy(new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 2));
        assertEquals(3, dragonList.getLarge());
    }

    @Test
    void deleteEnemy() throws IOException {
        DragonList.reset();
        DragonList dragonList = DragonList.getInstance();
        assertEquals(0, dragonList.getLarge());
        Dragon dragon1 = new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 1);
        dragonList.addEnemy(dragon1);
        assertEquals(1, dragonList.getLarge());
        dragonList.deleteEnemy(dragon1);
        assertEquals(0, dragonList.getLarge());
        dragonList.addEnemy(dragon1);
        Dragon dragon2 = new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 2);
        Dragon dragon3 = new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 25, 21, 80, 140, Holder.enemyRute, 3);
        dragonList.addEnemy(dragon2);
        dragonList.addEnemy(dragon3);
        assertEquals(3, dragonList.getLarge());
        dragonList.deleteEnemy(dragon3);
        assertEquals(2, dragonList.getLarge());
        dragonList.addEnemy(dragon3);
        dragonList.deleteEnemy(dragon2);
        assertEquals(2, dragonList.getLarge());
        dragonList.deleteEnemy(dragon1);
        assertEquals(1, dragonList.getLarge());
        assertEquals(25, dragonList.getLeftest());
    }

    @Test
    void allReady() throws IOException {
        DragonList.reset();
        DragonList dragonList = DragonList.getInstance();
        assertFalse(dragonList.allReady());
        Dragon dragon = new Dragon(0, GameUtil.generateName(), 40, 999, "Commander", 0, 21, 80, 140, Holder.enemyRute, 1);
        dragonList.addEnemy(dragon);
        assertFalse(dragonList.allReady());
        dragon.setTranslateX(0);
        dragon.setTranslateY(21);
        dragon.moveToX();
        dragon.moveToY();
        assertTrue(dragonList.allReady());
    }
}