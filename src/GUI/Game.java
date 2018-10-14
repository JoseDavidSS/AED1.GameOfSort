package GUI;

import Game.data.CollisionDetector;
import Logic.Lists.BulletsList;
import Logic.Lists.BulletsNodes;
import Logic.Lists.TemporalList;
import Logic.Lists.TemporalNode;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

import Game.Gryphon;
import Game.Attack;
import Game.Dragon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    String text = "Hello";
    String textAreaString = "";
    private int level = 1;
    public static int onScreenEnemies = 0;
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    private Gryphon player = new Gryphon(1, 50, 100, 150, 100, "file:src/Media/Players/Charizard.gif");
    final Logger logger = LoggerFactory.getLogger(Game.class);

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

        CollisionDetector collisionDetector = new CollisionDetector();
        collisionDetector.start();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();

        this.addEnemies();

    }

    private void shoot(String who){
        Attack attack = new Attack(1, player.getPosx() + 150, player.getPosy(), 60, 60, "file:src/Media/Bullets/Green Bullet.png", who);
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    //Tambien hacer uno que reciba arboles
    public void addEnemies(/*List*/){
        //Temporal
        int i = 0;
        int n = 10;
        while (i != 100){
            Dragon dragon = new Dragon(0, "Hol", 2, 122, "Comandante", 650, n, 100, 140, "file:src/Media/Players/Nightfury.gif");
            TemporalList.getInstance().addEnemy(dragon);
            n += 70;
            if (i % 10 == 0 && i != 0){
                n = 10;
            }
            i++;
        }
        TemporalList list = TemporalList.getInstance();
        //Termina lo temporal
        i = 0;
        TemporalNode tmp = list.head;
        while (i != 10){
            paneBoard.getChildren().add(tmp.getDragon());
            i++;
            onScreenEnemies++;
            tmp = tmp.next;
        }
    }

    //Corregir un error cuando los dragones llegan al lado izquierdo de la pantalla.

    private void update(){
        BulletsList tmp = BulletsList.getInstance();
        TemporalList tmp2 = TemporalList.getInstance();
        if (tmp.getLarge() != 0){
            BulletsNodes sub_tmp = tmp.head;
            while (sub_tmp != null){
                Attack sub_sub_tmp = sub_tmp.getAttack();
                if (sub_sub_tmp.getWho().equals("playerbullet")){
                    sub_sub_tmp.moveRight();
                    if (sub_sub_tmp.isDead()) {
                        paneBoard.getChildren().remove(sub_sub_tmp);
                        BulletsList.getInstance().deleteBullet(sub_sub_tmp);
                        sub_tmp = sub_tmp.next;
                    }else{
                        sub_tmp = sub_tmp.next;
                    }
                }
            }
        }
        if (tmp2.getLarge() != 0){
            TemporalNode sub_tmp2 = tmp2.head;
            int i = 0;
            while (onScreenEnemies != i){
                Dragon sub_sub_tmp2 = sub_tmp2.getDragon();
                sub_sub_tmp2.moveLeft();
                if (sub_sub_tmp2.isDead()){
                    paneBoard.getChildren().remove(sub_sub_tmp2);
                    TemporalList.getInstance().deleteEnemy(sub_sub_tmp2);
                    sub_tmp2 = sub_tmp2.next;
                    i++;
                    onScreenEnemies--;
                }else{
                    sub_tmp2 = sub_tmp2.next;
                    i++;
                }
            }
        }
    }

}
