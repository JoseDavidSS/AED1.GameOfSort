package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Beast extends Rectangle {

    private int resistence;
    private int posx;
    private int posy;

    public Beast (int resistence, int posx, int posy){
        super(50, 50, Color.BROWN);
        this.posx = posx;
        this.posy = posy;
        this.resistence = resistence;
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

    public void moveUp(){
        this.posy = this.posy - 5;
    }

    public void moveDown(){
        this.posy = this.posy + 5;
    }

    public void moveLeft(){
        this.posx = this.posx - 5;
    }

    public void moveRight(){
        this.posx = this.posx + 5;
    }
}
