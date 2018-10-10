package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class Game {
    String text = "hola";
    String textAreaString = "";
    @FXML private Text sideText;

    /**
     * Método que cambia la escena gracias a una instancia que llama del Main.
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");
    }

    public void addText (){
        textAreaString += String.format("%s%n", text);
        System.out.println("Segundo: "+textAreaString);
        this.sideText.setText(textAreaString);
    }

}
