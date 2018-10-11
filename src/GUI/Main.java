package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class to start the game
 */

public class Main extends Application {

    static Stage game;
    static Scene scene;

    /**
     * @param scene_route calls Game controller and defines which window to show
     * @throws IOException for error verification
     */
    static void setScene(String scene_route) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(scene_route));
        Scene sceneG = new Scene(root);
        double width = game.getWidth();
        double height = game.getHeight();
        boolean fullscreen = game.isFullScreen();
        game.setScene(sceneG);
        scene = sceneG;
    }

    /**
     * Executes GUI
     * @param args arguments to run class
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override

    /**
     * Defines which window shows when first run
     */
    public void start(Stage primaryStage) throws Exception{
        Main.game=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Game of Sorts");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}