package Game;

import GUI.Game;

public class Dragon extends Beast {

    private String name;
    private int rechargeSpeed;
    private int age;
    private String clas;
    private boolean readyY;
    private boolean readyX;
    private int ID;

    /**
     * Constructor of the Dragon class.
     * @param resistence integer with the life of the dragon.
     * @param name string with the name of the dragon.
     * @param rSpeed integer with the recharge speed of the dragon.
     * @param age integer with the age of the dragon.
     * @param clas string with the class of the dragon.
     * @param posx integer with the x position of the dragon.
     * @param posy integer with the y position of the dragon.
     * @param width integer with the width of the dragon.
     * @param height integer with the height of the dragon.
     * @param imgPath string with the path of the image of the dragon.
     * @param ID integer with the ID of the dragon.
     */
    public Dragon(int resistence, String name, int rSpeed, int age, String clas, int posx, int posy, int width, int height, String imgPath, int ID) {
        super(resistence, posx, posy, width, height, imgPath);
        this.name = name;
        this.rechargeSpeed = rSpeed;
        this.age = age;
        this.clas = clas;
        this.readyY = false;
        this.readyX = false;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRechargeSpeed() {
        return rechargeSpeed;
    }

    public void setRechargeSpeed(int rechargeSpeed) {
        this.rechargeSpeed = rechargeSpeed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public boolean isReadyY() {
        return readyY;
    }

    public void setReadyY(boolean readyY) {
        this.readyY = readyY;
    }

    public boolean isReadyX() {
        return readyX;
    }

    public void setReadyX(boolean readyX) {
        this.readyX = readyX;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Method to move the dragon to the left.
     */
    public void moveLeft() {
        if (this.getPosx() <= 0) {
            this.setDead(true);
            Game.lose += 1;
        } else {
            if (Math.random() < 0.4) {
                setTranslateX(this.getPosx() - 1);
                this.setPosx(this.getPosx() - 1);
            }
        }
    }

    /**
     * Method to move the dragon to a specific x position.
     */
    public void moveToX() {
        boolean ready = true;
        double posx = getTranslateX();
        if (this.getPosx() > posx) {
            posx += 1;
            this.setTranslateX(posx);
            ready = false;
        }
        if (this.getPosx() < posx) {
            posx -= 1;
            this.setTranslateX(posx);
            ready = false;
        }
        if (ready) {
            this.readyX = true;
        }
    }

    /**
     * Method to move the dragon to a specific y position.
     */
    public void moveToY() {
        boolean ready = true;
        double posy = getTranslateY();
        if (this.getPosy() > posy) {
            posy += 1;
            this.setTranslateY(posy);
            ready = false;
        }
        if (this.getPosy() < posy) {
            posy -= 1;
            this.setTranslateY(posy);
            ready = false;
        }
        if (ready) {
            this.readyY = true;
        }
    }
}