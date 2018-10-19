package GUI;

import Game.data.CollisionDetector;
import Game.data.MusicPlayer;
import Logic.Lists.BulletsList;
import Logic.Lists.BulletsNodes;
import Logic.Lists.DragonList;
import Logic.Lists.DragonNode;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
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
    private double enemySpawn = 0;
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
        Holder.playerRute ="file:src/Media/Players/Pony.gif";
    }
    public void choosePlayer3 (){
        Holder.playerRute = "file:src/Media/Players/FlyingBeast.gif";
    }
    public void choosePlayer4 (){
        Holder.playerRute = "file:src/Media/Players/PinkPegasus.gif";
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

        player = new Gryphon(2, 50, 100, 130, 80, Holder.playerRute);
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

        MusicPlayer musicPlayer = new MusicPlayer("src/Media/Audio/CastleTheme.mp3");
        musicPlayer.start();

        this.temporalMethod();

    }

    private void shoot(){
        Attack attack = new Attack(0, player.getPosx() + 150, player.getPosy(), 40, 40, "file:src/Media/Bullets/Green Bullet.png", "playerbullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    public void shoot(Dragon dragon){
        Attack attack = new Attack(0, dragon.getPosx(), dragon.getPosy() + 20, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    public void addEnemies(){
        DragonList list = DragonList.getInstance();
        int i = 0;
        DragonNode tmp = list.head;
        Image img = new Image(Holder.enemyRute);
        ImagePattern ing = new ImagePattern(img);
        while (i != onScreenEnemies){
            tmp = tmp.next;
            i++;
        }
        i = 0;
        while (i != 10){
            System.out.println(Holder.playerRute);
            tmp.getDragon().setFill(ing);
            paneBoard.getChildren().add(tmp.getDragon());
            i++;
            onScreenEnemies++;
            tmp = tmp.next;
        }
    }

    public void temporalMethod(){
        int i = 0;
        int n = 5;
        while (i != 100){
            Dragon dragon = new Dragon(0, "Hol", 100, 122, "Comandante", 830, n, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
            DragonList.getInstance().addEnemy(dragon);
            n += 70;
            if (i % 10 == 0 && i != 0){
                n = 5;
            }
            i++;
        }
        this.addEnemies();
    }

    //Corregir un error cuando los dragones llegan al lado izquierdo de la pantalla.

    private void update(){
        BulletsList tmp = BulletsList.getInstance();
        DragonList tmp2 = DragonList.getInstance();
        this.enemyShoot += 0.016;
        this.enemySpawn += 0.016;
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
            try {
                DragonNode sub_tmp2 = tmp2.head;
                int i = 0;
                while (onScreenEnemies != i){
                    Dragon sub_sub_tmp2 = sub_tmp2.getDragon();
                    if (inFormation){
                        sub_sub_tmp2.moveLeft();
                        if (this.enemyShoot > 2){
                            if (Math.random() < 0.5 && sub_sub_tmp2.getRechargeSpeed() >= 70) {
                                this.shoot(sub_sub_tmp2);
                            }if (Math.random() < 0.3 && sub_sub_tmp2.getRechargeSpeed() < 70 && sub_sub_tmp2.getRechargeSpeed() >= 40) {
                                this.shoot(sub_sub_tmp2);
                            }if (Math.random() < 0.2 && sub_sub_tmp2.getRechargeSpeed() < 40) {
                                this.shoot(sub_sub_tmp2);
                            }
                        }
                    }
                    if (sub_sub_tmp2.isDead()){
                        paneBoard.getChildren().remove(sub_sub_tmp2);
                        DragonList.getInstance().deleteEnemy(sub_sub_tmp2);
                        sub_tmp2 = sub_tmp2.next;
                        i++;
                        onScreenEnemies--;
                    }else{
                        sub_tmp2 = sub_tmp2.next;
                        i++;
                    }
                }
            }catch (NullPointerException e){}
        }if (this.enemyShoot > 2) {
            this.enemyShoot = 0;
        }if (this.enemySpawn > 10){
            this.addEnemies();
            this.enemySpawn = 0;
        }
    }
}
