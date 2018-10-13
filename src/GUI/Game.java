package GUI;

import Logic.Lists.BulletsList;
import Logic.Lists.BulletsNodes;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

import Game.Gryphon;
import Game.Attack;

public class Game {

    String text = "Hello";
    String textAreaString = "";
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    private Gryphon player = new Gryphon(1, 50, 100, 150, 100, "file:src/Media/Players/Charizard.gif");

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
                    this.shoot("playerbullet");
                    break;
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    public void shoot(String who){
        Attack attack = new Attack(1, player.getPosx() + 150, player.getPosy(), 80, 80, "file:src/Media/Bullets/Green Bullet.png", who);
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    public void update(){
        BulletsList tmp = BulletsList.getInstance();
        if (tmp.getLarge() != 0){
            BulletsNodes sub_tmp = tmp.head;
            while (sub_tmp != null){
                Attack sub_sub_tmp = sub_tmp.getAttack();
                if (sub_sub_tmp.getWho().equals("playerbullet")){
                    sub_sub_tmp.moveRight();
                    if (sub_sub_tmp.isDead()){
                        paneBoard.getChildren().remove(sub_sub_tmp);
                        BulletsList.getInstance().deleteBullet(sub_sub_tmp);
                        sub_tmp = sub_tmp.next;
                    }else{
                        sub_tmp = sub_tmp.next;
                    }
                }
            }
        }
    }

}
