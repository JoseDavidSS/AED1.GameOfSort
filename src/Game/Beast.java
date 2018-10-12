package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Beast extends Rectangle {

    private int resistence;
    private int posx;
    private int posy;

    public Beast (int resistence, int posx, int posy, int width, int height){
        super(width, height, Color.BISQUE);
        setTranslateX(posx);
        setTranslateY(posy);

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
