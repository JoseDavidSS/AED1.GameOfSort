package GUI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import Game.Grifo;

public class Game {

    String text = "hola";
    String textAreaString = "";
    private AnchorPane paneBoard;
    //private Grifo player = new Grifo(1, 50, 50);
    @FXML private TextArea sideText;

    /**
     * Método que cambia la escena gracias a una instancia que llama del Main.
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");
        Image heroImage = new Image((new FileInputStream("C:\\Users\\Kevin Cordero Zúñiga\\IdeaProjects\\Game of Sorts\\game_data\\images\\grifo.png")));
        Node hero = new ImageView(heroImage);
        //hero = new ImageView(heroImage);
        //paneBoard.getChildren().add(player);
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
        paneBoard.getChildren().add(hero);
    }



    public void addText (){
        textAreaString += String.format("%s%n", text);
        System.out.println("Segundo: "+textAreaString);
        this.sideText.setText(textAreaString);
    }

}
