package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase para iniciar la interfaz.
 */

public class Main extends Application {

    static Stage game;

    /**
     * @param scene_route es un argumento que entra al momento de ser llamado por el controller Game y así definir cuál ventana mostrar.
     * @throws IOException se usa para verifica cuando hay errores
     */

    static void setScene(String scene_route) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(scene_route));
        Scene scene = new Scene(root);
        double width = game.getWidth();
        double height = game.getHeight();
        boolean fullscreen = game.isFullScreen();
        game.setScene(scene);

    }

    /**
     * main es el método que ejecuta la clase una vez que se inicializa.
     * @param args argumentos que son necesarios para inicializar y correr la clase.
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    /**
     * El método start se utiliza para definir con qué ventana se iniciará la interfaz.
     */

    public void start(Stage primaryStage) throws Exception{
        Main.game=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("¡¡ Game of Sorts !!");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}