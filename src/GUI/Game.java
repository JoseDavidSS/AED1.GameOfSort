package GUI;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import Game.Gryphon;

public class Game {

    String text = "Hello";
    String textAreaString = "";
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    private Gryphon player = new Gryphon(1, 50, 50);

    /**
     * Changes scene by calling main class
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");

        Main.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    System.out.println("Up");
                    break;
                case A:
                    System.out.println("Left");
                    break;
                case D:
                    System.out.println("Right");
                    break;
                case S:
                    System.out.println("Down");
                    break;
                case SPACE:
                    System.out.println("Shot");
                    break;
            }
        });
    }

/*
    public void addPlayer(){
        Image img = new Image("file:grifo.png");
        player.setFill(new ImagePattern(img));
        paneBoard.getChildren().addAll(player);
    }
*/

    public void addText (){
        textAreaString += String.format("%s%n", text);
        System.out.println("Second: "+textAreaString);
        this.sideText.setText(textAreaString);
        //addPlayer();
    }

}
