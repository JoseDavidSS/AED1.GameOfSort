package Game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Beast extends Rectangle {

    private int resistence;
    private int posx;
    private int posy;
    private boolean dead;

    public Beast (int resistence, int posx, int posy, int width, int height, String imgPath){
        super(width, height, Color.BISQUE);
        this.setTranslateX(posx);
        this.setTranslateY(posy);
        Image img = new Image(imgPath);
        this.setFill(new ImagePattern(img));

        this.posx = posx;
        this.posy = posy;
        this.resistence = resistence;
        this.dead = false;
    }

    public int getResistence() {
        return resistence;
    }

    public void setResistence(int resistence) {
        this.resistence = resistence;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void moveUp(){
        if (this.posy == 0){
        }else{
            setTranslateY(this.posy - 10);
            this.posy = this.posy - 10;
        }
    }

    public void moveDown(){
        if (this.posy == 700){
        }else{
            setTranslateY(this.posy + 10);
            this.posy = this.posy + 10;
        }
    }

    public void moveLeft(){
        if (this.posx == 0){
        }else{
            setTranslateX(this.posx - 10);
            this.posx = this.posx - 10;
        }
    }

    public void moveRight(){
        if (this.posx == 650){
        }else{
            setTranslateX(this.posx + 10);
            this.posx = this.posx + 10;
        }
    }
}
