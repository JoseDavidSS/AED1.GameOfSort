package Game;

public class Dragon extends Beast {

    private String name;
    private int rechargeSpeed;
    private int age;
    private String clas;
    public Dragon left;
    public Dragon right;

    public Dragon(String path, int resistence, String name, int rSpeed, int age, String clas, int posx, int posy) {
        super(path, resistence, posx, posy);
        this.name = name;
        this.rechargeSpeed = rSpeed;
        this.age = age;
        this.clas = clas;
        this.left = null;
        this.right = null;
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
}
