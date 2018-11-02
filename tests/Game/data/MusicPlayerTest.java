package Game.data;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    @BeforeAll
    public static void init(){
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Test
    void run() {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setPath("src/Media/Audio/DesertTheme.mp3");
        assertNotNull(musicPlayer.getPath());
        musicPlayer.run();
        musicPlayer.stopMusic();
    }
}