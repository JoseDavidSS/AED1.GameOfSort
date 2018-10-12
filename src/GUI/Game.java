package GUI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import Game.Gryphon;

public class Game {

    String text = "Hello";
    String textAreaString = "";
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    private Gryphon player = new Gryphon(1, 50, 100, 150, 100);

    /**
     * Changes scene by calling main class
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");
    }

    public void inicioJuego (){
        textAreaString += String.format("%s%n", text);
        System.out.println("Second: "+textAreaString);
        this.sideText.setText(textAreaString);

        Image img = new Image("file:C:\\Users\\Kevin Cordero Zúñiga\\IdeaProjects\\Game of Sorts\\game_data\\images\\gryphon.png");
        player.setFill(new ImagePattern(img));
        paneBoard.getChildren().add(player);

        Main.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A:
                    player.moveLeft();
                    break;
                case D:
                    player.moveRight();
                    break;
                case W:
                    player.moveUp();
                    break;
                case S:
                    player.moveDown();
                    break;
                case K:
                    System.out.println("Shoot");
                    break;
            }
        });
    }

}
