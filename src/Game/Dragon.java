package Game;

public class Dragon extends Beast {

    private String name;
    private int rechargeSpeed;
    private int age;
    private String clas;
    private boolean readyY;
    private boolean readyX;

    public Dragon(int resistence, String name, int rSpeed, int age, String clas, int posx, int posy, int width, int height, String imgPath) {
        super(resistence, posx, posy, width, height, imgPath);
        this.name = name;
        this.rechargeSpeed = rSpeed;
        this.age = age;
        this.clas = clas;
        this.readyY = false;
        this.readyX = false;
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

    public void moveLeft() {
        if (this.getPosx() <= 0) {
            this.setDead(true);
        } else if (this.getPosx() == 1200) {
            this.setPosx(900);
            setTranslateX(900);
        } else {
            if (Math.random() < 0.4) {
                setTranslateX(this.getPosx() - 1);
                this.setPosx(this.getPosx() - 1);
            }
        }
    }

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