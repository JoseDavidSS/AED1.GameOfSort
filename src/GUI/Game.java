package GUI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.IOException;
import Game.Grifo;

public class Game {

    String text = "hola";
    String textAreaString = "";
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    private Grifo player = new Grifo(1, 50, 50);

    /**
     * Método que cambia la escena gracias a una instancia que llama del Main.
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");

        Main.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    System.out.println("Arriba");
                    break;
                case A:
                    System.out.println("Izquierda");
                    break;
                case D:
                    System.out.println("Derecha");
                    break;
                case S:
                    System.out.println("Abajo");
                    break;
                case SPACE:
                    System.out.println("Disparo");
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
        System.out.println("Segundo: "+textAreaString);
        this.sideText.setText(textAreaString);
        //addPlayer();
    }

}
