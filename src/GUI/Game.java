package GUI;

import Game.data.MusicPlayer;
import Logic.Lists.*;
import Server.Serializer;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import Game.Gryphon;
import Game.Attack;
import Game.Dragon;
import Game.GameUtil;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Game {

    private int BACKGROUND_WIDTH = 1200;
    private ParallelTransition parallelTransition;
    String text = "Hello";
    String textAreaString = "";
    private int level = 1;
    public boolean inFormation = true;
    private double enemyShoot = 0;
    private int whichFormation = 0;
    @FXML private Text sideText;
    @FXML private AnchorPane paneBoard;
    @FXML private ImageView background1;
    @FXML private ImageView background2;
    @FXML private static Label livesLeftTxt;
    @FXML private static Label enemiesLeftTxt;
    @FXML private static Label levelTxt;
    @FXML private static Label currentOrderTxt;

    public static Gryphon player;
    final Logger logger = LoggerFactory.getLogger(Game.class);

    /**
     * Defines player´s first skin (image rute)
     */
    public void choosePlayer1 (){
        Holder.playerRute ="file:src/Media/Players/Charizard.gif";

    }

    /**
     * Defines player´s second skin (image rute)
     */
    public void choosePlayer2 (){
        Holder.playerRute ="file:src/Media/Players/Pony.gif";
    }

    /**
     * Defines player´s third skin (image rute)
     */
    public void choosePlayer3 (){
        Holder.playerRute = "file:src/Media/Players/FlyingBeast.gif";
    }

    /**
     * Defines player´s fourth skin (image rute)
     */
    public void choosePlayer4 (){
        Holder.playerRute = "file:src/Media/Players/PinkPegasus.gif";
    }

    /**
     * Defines enemies´ first skin (image rute)
     */
    public void chooseEnemy1 (){
        Holder.enemyRute = "file:src/Media/Enemies/BlackDragon.gif";
    }

    /**
     * Defines enemies´ second skin (image rute)
     */
    public void chooseEnemy2 (){
        Holder.enemyRute = "file:src/Media/Enemies/GreenDragon.gif";
    }

    /**
     * Defines enemies´ third skin (image rute)
     */
    public void chooseEnemy3 (){
        Holder.enemyRute = "file:src/Media/Enemies/Nightfury.gif";
    }

    /**
     * Defines enemies´ fourth skin (image rute)
     */
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

    /**
     * startGame is a method called by Main class to start the game
     */
    public void startGame(){

        parallelTransition.play();

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
                case ESCAPE:
                    System.exit(0);
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

        MusicPlayer musicPlayer = new MusicPlayer("src/Media/Audio/CastleTheme.mp3");
        musicPlayer.start();

        try {
            this.temporalMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * shoot() is a method used to create and move player's bullets
     */
    private void shoot(){
        Attack attack = new Attack(0, player.getPosx() + 150, player.getPosy(), 40, 40, "file:src/Media/Bullets/Green Bullet.png", "playerbullet");
        paneBoard.getChildren().add(attack);
        BulletsList.getInstance().addBullet(attack);
    }

    /**
     * shoot(Dragon dragon) is a method used to create and move enemies' bullets
     */
    public void shoot(Dragon dragon){
        if (dragon.getPosx() < 900){
            Attack attack = new Attack(0, dragon.getPosx(), dragon.getPosy() + 20, 40, 40, "file:src/Media/Bullets/Fire.png", "enemybullet");
            paneBoard.getChildren().add(attack);
            BulletsList.getInstance().addBullet(attack);
        }
    }

    /**
     * addEnemies is a method used to add enemies
     */
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
        int y = 15;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        int id = 1;
        while (i != 100){
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first){
                first = true;
                clas = "Commander";
                resistence = 2;
            }
            if (resistence < 2){
                clas = "Infantry";
            }
            Dragon dragon = new Dragon(resistence, dragonName, rSpeed, age, clas, x, y, 80, 140, "file:src/Media/Enemies/Nightfury.gif", id);
            DragonList.getInstance().addEnemy(dragon);
            y += 70;
            if (i % 9 == 0 && i != 0){
                y = 15;
                if (!fLine){
                    x += 400;
                    fLine = true;
                }
                else{
                    x += 400;
                }
            }
            i++;
            id++;
        }
        this.addEnemies();
    }

    /**
     * update() is a method used to refresh and update game data
     */
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
                    BulletsNodes sub_tmp3 = tmp.head;
                    while (sub_tmp3 != null){
                        Attack sub_sub_tmp3 = sub_tmp3.getAttack();
                        if (!sub_sub_tmp3.getWho().equals("playerbullet")){
                            if (sub_sub_tmp.getBoundsInParent().intersects(sub_sub_tmp3.getBoundsInParent())){
                                sub_sub_tmp.setDead(true);
                                sub_sub_tmp3.setDead(true);
                                break;
                            }
                        }
                        sub_tmp3 = sub_tmp3.next;
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
        }if (tmp2.getLarge() != 0) {
            DragonNode sub_tmp2 = tmp2.head;
            while (sub_tmp2 != null) {
                Dragon sub_sub_tmp2 = sub_tmp2.getDragon();
                if (inFormation) {
                    sub_sub_tmp2.moveLeft();
                    if (sub_sub_tmp2 == tmp2.head.getDragon()) {
                        tmp2.setLeftest(sub_sub_tmp2.getPosx());
                    }
                    if (this.enemyShoot > 2) {
                        if (Math.random() < 0.5 && sub_sub_tmp2.getRechargeSpeed() >= 70) {
                            this.shoot(sub_sub_tmp2);
                        }
                        if (Math.random() < 0.3 && sub_sub_tmp2.getRechargeSpeed() < 70 && sub_sub_tmp2.getRechargeSpeed() >= 40) {
                            this.shoot(sub_sub_tmp2);
                        }
                        if (Math.random() < 0.2 && sub_sub_tmp2.getRechargeSpeed() < 40) {
                            this.shoot(sub_sub_tmp2);
                        }
                    }
                }
                if (sub_sub_tmp2.isDead()) {
                    paneBoard.getChildren().remove(sub_sub_tmp2);
                    DragonList.getInstance().deleteEnemy(sub_sub_tmp2);
                    this.inFormation = false;
                    this.changeFormation();
                }
                sub_tmp2 = sub_tmp2.next;
            }
        }if (!this.inFormation){
            DragonNode sub_tmp2 = tmp2.head;
            while (sub_tmp2 != null){
                sub_tmp2.getDragon().moveToX();
                sub_tmp2.getDragon().moveToY();
                sub_tmp2 = sub_tmp2.next;
            }
            if (tmp2.allReady()){
                this.inFormation = true;
            }
        }if (this.enemyShoot > 2) {
            this.enemyShoot = 0;
        }
    }

    public void changeFormation(){
        if (this.whichFormation == 0){
            //Pruebas
            SendList sl = new SendList();
            DragonList dl = DragonList.getInstance();
            DragonNode tmp = dl.head;
            while (tmp != null){
                Dragon dragon = tmp.getDragon();
                sl.addData(dragon.getAge(),dragon.getRechargeSpeed(), dragon.getClas(), dragon.getPosx(), dragon.getPosy(), dragon.getID(), dragon.getName(), dragon.getResistence());
                tmp = tmp.next;
            }
            try {
                Serializer.serializadorString(sl);
                this.whichFormation++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (this.whichFormation == 1){

            this.whichFormation++;
        }else if (this.whichFormation == 2){

            this.whichFormation++;
        }else if (this.whichFormation == 3){

            this.whichFormation = 0;
        }
    }

    /**
     * initialize is a method used to add a moving background to the paneBoard
     */
    @FXML
    public void initialize() {

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(10000), background1);
        translateTransition.setFromX(0);
        translateTransition.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(10000), background2);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition2.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition( translateTransition, translateTransition2 );
        parallelTransition.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * setLivesLeftTxt() is a method used to set livesLeftTxt label text
     */
    public static void setLivesLeftTxt (int lives){
        Integer.toString(lives);
        livesLeftTxt.setText("Lives left: " + lives);
    }

    /**
     * setEnemiesLeftTxt() is a method used to set enemiesLeftTxt label text
     */
    public static void setEnemiesLeftTxt (int enemies){
        Integer.toString(enemies);
        enemiesLeftTxt.setText("Enemies left: " + enemies);
    }

    /**
     * setLevelTxt() is a method used to set levelTxt label text
     */
    public static void setLevelTxt (int level){
        Integer.toString(level);
        levelTxt.setText("Level: " + level);
    }

    /**
     * setCurrentOrderTxt() is a method used to set currentOrderTxt label text
     */
    public static void setCurrentOrderTxt (String currentOrder){
        currentOrderTxt.setText("Current order: " + currentOrder);
    }
}
