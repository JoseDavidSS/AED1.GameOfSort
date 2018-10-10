package Game;

import javafx.scene.image.Image;

public class Beast {

    private int resistence;
    private int posx;
    private int posy;
    private String imagePath;

    public Beast (String path, int resistence, int posx, int posy){
        this.imagePath = path;
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
