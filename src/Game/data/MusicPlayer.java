package Game.data;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MusicPlayer {

    private String path;
    private Media media;
    private MediaPlayer player;
    final Logger logger = LoggerFactory.getLogger(MusicPlayer.class);

    /**
     * Constructor of the Music Player class.
     */
    public MusicPlayer(){
    }

    /**
     * Run method of the thread in this class, initializes the player.
     */
    public void run(){
        logger.info("Starting music.");
        media = new Media(new File(this.path).toURI().toString());
        player = new MediaPlayer(media);
        player.play();
    }

    public void stopMusic(){
        logger.info("Stopping music.");
        player.stop();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
