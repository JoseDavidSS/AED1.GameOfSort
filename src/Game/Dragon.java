package Game;

public class Dragon extends Beast {

    private String name;
    private int rechargeSpeed;
    private int age;
    private String clas;

    public Dragon(int resistence, String name, int rSpeed, int age, String clas, int posx, int posy, int width, int height, String imgPath) {
        super(resistence, posx, posy, width, height, imgPath);
        this.name = name;
        this.rechargeSpeed = rSpeed;
        this.age = age;
        this.clas = clas;
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

    public void moveLeft(){
        if (this.getPosx() <= 0){
            this.setDead(true);
        }else{
            if (Math.random() < 0.4) {
                setTranslateX(this.getPosx() - 1);
                this.setPosx(this.getPosx() - 1);
            }
        }
    }
}
