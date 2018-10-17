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
    public static boolean inFormation = true;
    private double enemyShoot = 0;
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    public static Gryphon player;
    final Logger logger = LoggerFactory.getLogger(Game.class);

    public void print (){
        System.out.println(Holder.playerRute);
    }
    public void choosePlayer1 (){
        Holder.playerRute ="file:src/Media/Players/Charizard.gif";
    }
    public void choosePlayer2 (){
        Holder.playerRute ="file:src/Media/Players/FlyingBeast.gif";
    }
    public void choosePlayer3 (){
        Holder.playerRute = "file:src/Media/Players/Pony.gif";
    }
    public void choosePlayer4 (){
        Holder.playerRute = "file:src/Media/Players/Angel.gif";
    }
    public void chooseEnemy1 (){
        Holder.enemyRute = "file:src/Media/Enemies/BlackDragon.gif";
    }
    public void chooseEnemy2 (){
        Holder.enemyRute = "file:src/Media/Enemies/GreenDragon.gif";
    }
    public void chooseEnemy3 (){
        Holder.enemyRute = "file:src/Media/Enemies/Nightfury.gif";
    }
    public void chooseEnemy4 (){
        Holder.enemyRute = "file:src/Media/Enemies/YellowDragon.gif";
    }

    /**
     * Changes scene from Menu to Instructions
     */
    public void runInstructions () throws IOException {
        Main.setScene("Instructions.fxml");
    }

    /**
     * Changes scene from Instructions to SetUp
     */
    public void runSetUp () throws IOException {
        Main.setScene("SetUp.fxml");
    }

    /**
     * Changes scene from SetUp to Board
     */
    public void runBoard () throws IOException {
        Main.setScene("Board.fxml");
    }

    public void startGame(){
        textAreaString += String.format("%s%n", text);
        System.out.println("Second: "+textAreaString);
        this.sideText.setText(textAreaString);

        player = new Gryphon(2, 50, 100, 150, 100, Holder.playerRute);
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
                    if (inFormation){
                        this.shoot();
                    }
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

    private void shoot(){
        Attack attack = new Attack(0, player.getPosx() + 150, player.getPosy(), 60, 60, "file:src/Media/Bullets/Green Bullet.png", "playerbullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    public void shoot(Dragon dragon){
        Attack attack = new Attack(0, dragon.getPosx(), dragon.getPosy() + 20, 60, 60, "file:src/Media/Bullets/Fire.png", "enemybullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    //Tambien hacer uno que reciba arboles
    public void addEnemies(/*List*/){
        //Temporal
        int i = 0;
        int n = 50;
        while (i != 100){
            Dragon dragon = new Dragon(0, "Hol", 2, 122, "Comandante", 650, n, 100, 160, Holder.enemyRute);
            TemporalList.getInstance().addEnemy(dragon);
            n += 100;
            if (i % 6 == 0 && i != 0){
                n = 50;
            }
            i++;
        }
        TemporalList list = TemporalList.getInstance();
        //Termina lo temporal
        i = 0;
        TemporalNode tmp = list.head;
        while (i != 6){
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
        this.enemyShoot += 0.016;
        if (player.isDead()){
            paneBoard.getChildren().remove(player);
            System.out.println("MORI");
        }if (tmp.getLarge() != 0){
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
                }else{
                    sub_sub_tmp.moveLeft();
                    if (sub_sub_tmp.isDead()) {
                        paneBoard.getChildren().remove(sub_sub_tmp);
                        BulletsList.getInstance().deleteBullet(sub_sub_tmp);
                        sub_tmp = sub_tmp.next;
                    }else{
                        sub_tmp = sub_tmp.next;
                    }
                }
            }
        }if (tmp2.getLarge() != 0){
            TemporalNode sub_tmp2 = tmp2.head;
            int i = 0;
            while (onScreenEnemies != i){
                Dragon sub_sub_tmp2 = sub_tmp2.getDragon();
                if (inFormation){
                    sub_sub_tmp2.moveLeft();
                    if (this.enemyShoot > 2){
                        if (Math.random() < 0.4) {
                            this.shoot(sub_sub_tmp2);
                        }
                    }
                }
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
        }if (this.enemyShoot > 2) {
            this.enemyShoot = 0;
        }
    }
}
