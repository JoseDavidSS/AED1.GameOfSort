package Game;

public class Attack extends Beast {

    private String who;

    /**
     * Constructor of the Attack class.
     * @param resistence integer with the life of the bullet.
     * @param posx integer with the x position of the bullet.
     * @param posy integer with the y position of the bullet.
     * @param width integer with the width of the bullet.
     * @param height integer with the height of the bullet.
     * @param imgPath string with the path of the image of the bullet.
     * @param who string with the name of the sprite that shoot the bullet.
     */
    public Attack(int resistence, int posx, int posy, int width, int height, String imgPath, String who) {
        super(resistence, posx, posy, width, height, imgPath);

        this.who = who;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    /**
     * Method to move the bullet to the right.
     */
    public void moveRight(){
        if (this.getPosx() >= 900){
            this.setDead(true);
        }else{
            setTranslateX(this.getPosx() + 5);
            this.setPosx(this.getPosx() + 5);
        }
    }

    /**
     * Method to move the bullet to the left.
     */
    public void moveLeft(){
        if (this.getPosx() == 0){
            this.setDead(true);
        }else{
            setTranslateX(this.getPosx() - 2);
            this.setPosx(this.getPosx() - 2);
        }
    }

}
