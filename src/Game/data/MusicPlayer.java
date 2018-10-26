package Game.data;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayer extends Thread {

    private String path;

    /**
     * Constructor of the Music Player class.
     * @param path String with the path of the file to play.
     */
    public MusicPlayer(String path){
        this.path = path;
    }

    /**
     * Run method of the thread in this class, initializes the player.
     */
    public void run(){
        Media media = new Media(new File(this.path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

}
