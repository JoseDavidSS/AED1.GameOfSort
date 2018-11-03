package GUI;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Game.Gryphon;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeAll
    public static void init() {
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Test
    void choosePlayer1() {
        Game game = new Game();
        Holder.playerRute = null;
        game.choosePlayer1();
        assertEquals("file:src/Media/Players/Charizard.gif", Holder.playerRute);
    }

    @Test
    void choosePlayer2() {
        Game game = new Game();
        Holder.playerRute = null;
        game.choosePlayer2();
        assertEquals("file:src/Media/Players/Pony.gif", Holder.playerRute);
    }

    @Test
    void choosePlayer3() {
        Game game = new Game();
        Holder.playerRute = null;
        game.choosePlayer3();
        assertEquals("file:src/Media/Players/FlyingBeast.gif", Holder.playerRute);
    }

    @Test
    void choosePlayer4() {
        Game game = new Game();
        Holder.playerRute = null;
        game.choosePlayer4();
        assertEquals("file:src/Media/Players/PinkPegasus.gif", Holder.playerRute);
    }

    @Test
    void chooseEnemy1() {
        Game game = new Game();
        Holder.enemyRute = null;
        game.chooseEnemy1();
        assertEquals("file:src/Media/Enemies/BlackDragon.gif", Holder.enemyRute);
    }

    @Test
    void chooseEnemy2() {
        Game game = new Game();
        Holder.enemyRute = null;
        game.chooseEnemy2();
        assertEquals("file:src/Media/Enemies/GreenDragon.gif", Holder.enemyRute);
    }

    @Test
    void chooseEnemy3() {
        Game game = new Game();
        Holder.enemyRute = null;
        game.chooseEnemy3();
        assertEquals("file:src/Media/Enemies/Nightfury.gif", Holder.enemyRute);
    }

    @Test
    void chooseEnemy4() {
        Game game = new Game();
        Holder.enemyRute = null;
        game.chooseEnemy4();
        assertEquals("file:src/Media/Enemies/YellowDragon.gif", Holder.enemyRute);
    }

    @Test
    void addEnemies() {

    }

    @Test
    void changeFormation() {
    }

    @Test
    void getNewList() {
    }

    @Test
    void errorWindow() {
    }

    @Test
    void showDragonStats() {
    }

    @Test
    void showBTree() {
    }

    @Test
    void setLivesLeftTxt() {
    }

    @Test
    void setEnemiesLeftTxt() {
    }

    @Test
    void setLevelTxt() {
    }

    @Test
    void setCurrentOrderTxt() {
    }

    @Test
    void readLevel() {
    }
}