package Game.data;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayer extends Thread {

    private String path;

    public MusicPlayer(String path){
        this.path = path;
    }

    public void run(){
        Media media = new Media(new File(this.path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }

}
