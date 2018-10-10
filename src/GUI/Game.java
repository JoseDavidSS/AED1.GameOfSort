package GUI;

import javafx.fxml.FXML;

import java.io.IOException;

public class Game {
    @FXML

    /**
     * Método que cambia la escena gracias a una instancia que llama del Main.
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");
    }

}
