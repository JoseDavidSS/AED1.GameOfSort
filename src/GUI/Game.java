package GUI;

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
import Game.GameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Game {

    String text = "Hello";
    String textAreaString = "";
    private int level = 1;
    public boolean inFormation = true;
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

        player = new Gryphon(10, 50, 100, 130, 80, Holder.playerRute);
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
                    if (inFormation && !player.isDead()){
                        this.shoot();
                    }
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

        /*
        MusicPlayer musicPlayer = new MusicPlayer("src/Media/Audio/CastleTheme.mp3");
        musicPlayer.start();*/

        try {
            this.temporalMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void shoot(){
        Attack attack = new Attack(0, player.getPosx() + 150, player.getPosy(), 40, 40, "file:src/Media/Bullets/Green Bullet.png", "playerbullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    public void shoot(Dragon dragon){
        if (dragon.getPosx() < 900){
            Attack attack = new Attack(0, dragon.getPosx(), dragon.getPosy() + 20, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
            paneBoard.getChildren().add(attack);
            BulletsList.getInstance().addBullet(attack);
        }
    }

    public void addEnemies(){
        DragonList list = DragonList.getInstance();
        DragonNode tmp = list.head;
        Image img = new Image(Holder.enemyRute);
        ImagePattern ing = new ImagePattern(img);
        while (tmp != null){
            tmp.getDragon().setFill(ing);
            paneBoard.getChildren().add(tmp.getDragon());
            tmp = tmp.next;
        }
    }

    public void temporalMethod() throws IOException {
        int i = 0;
        int y = 5;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        while (i != 100){
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first){
                first = true;
                clas = "Commander";
            }
            if (resistence < 2){
                clas = "Infantry";
            }
            Dragon dragon = new Dragon(resistence, dragonName, rSpeed, age, clas, x, y, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
            DragonList.getInstance().addEnemy(dragon);
            y += 70;
            if (i % 10 == 0 && i != 0){
                y = 5;
                if (!fLine){
                    x += 800;
                    fLine = true;
                }
                else{
                    x += 500;
                }
            }
            i++;
        }
        this.addEnemies();
    }

    private void update(){
        BulletsList tmp = BulletsList.getInstance();
        DragonList tmp2 = DragonList.getInstance();
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
                    DragonNode sub_tmp2 = tmp2.head;
                    while (sub_tmp2 != null){
                        Dragon sub_sub_tmp2 = sub_tmp2.getDragon();
                        if (sub_sub_tmp.getBoundsInParent().intersects(sub_sub_tmp2.getBoundsInParent())) {
                            sub_sub_tmp.setDead(true);
                            sub_sub_tmp2.hit();
                            break;
                        }
                        sub_tmp2 = sub_tmp2.next;
                    }
                    if (sub_sub_tmp.isDead()) {
                        paneBoard.getChildren().remove(sub_sub_tmp);
                        BulletsList.getInstance().deleteBullet(sub_sub_tmp);
                    }
                    sub_tmp = sub_tmp.next;
                }else{
                    sub_sub_tmp.moveLeft();
                    if (sub_sub_tmp.getBoundsInParent().intersects((player.getBoundsInParent()))) {
                        sub_sub_tmp.setDead(true);
                        player.hit();
                    }if (sub_sub_tmp.isDead()) {
                        paneBoard.getChildren().remove(sub_sub_tmp);
                        BulletsList.getInstance().deleteBullet(sub_sub_tmp);
                    }
                    sub_tmp = sub_tmp.next;
                }
            }
        }if (tmp2.getLarge() != 0){
            DragonNode sub_tmp2 = tmp2.head;
            while (sub_tmp2 != null){
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
                }if (sub_sub_tmp2.isDead()) {
                    paneBoard.getChildren().remove(sub_sub_tmp2);
                    DragonList.getInstance().deleteEnemy(sub_sub_tmp2);
                    this.inFormation = false;
                    this.reorganize();
                }
                sub_tmp2 = sub_tmp2.next;
            }
        }if (this.enemyShoot > 2) {
            this.enemyShoot = 0;
        }
    }

    public void reorganize(){
        DragonList sList = DragonList.getInstance();
        //Se llama al server.
        DragonList nList = DragonList.getInstance();
        if (sList.getLarge() != 0){
            DragonNode sDragon;
            DragonNode nDragon = nList.head;
            while (nDragon != null){
                sDragon = nList.head;
                while (sDragon != null){
                    if (sDragon == nDragon){
                        System.out.println("Hacer el cambio");
                        sList.deleteEnemy(sDragon.getDragon());
                        break;
                    }
                    sDragon = sDragon.next;
                }
                nDragon = nDragon.next;
            }
        }
    }
}
