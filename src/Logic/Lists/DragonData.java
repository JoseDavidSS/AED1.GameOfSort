package Logic.Lists;

public class DragonData {

    private String name;
    private int dAge;
    private int dRSpeed;
    private int resistence;
    private String dClas;
    private int posx;
    private int posy;
    private int ID;

    public DragonData(int dAge, int dRSpeed, String dClas, int posx, int posy, int ID, String name, int resistence){
        this.dAge = dAge;
        this.dRSpeed = dRSpeed;
        this.dClas = dClas;
        this.name = name;
        this.resistence = resistence;
        this.posx = posx;
        this.posy = posy;
        this.ID = ID;
    }

    public DragonData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getdAge() {
        return dAge;
    }

    public void setdAge(int dAge) {
        this.dAge = dAge;
    }

    public int getdRSpeed() {
        return dRSpeed;
    }

    public void setdRSpeed(int dRSpeed) {
        this.dRSpeed = dRSpeed;
    }

    public int getResistence() {
        return resistence;
    }

    public void setResistence(int resistence) {
        this.resistence = resistence;
    }

    public String getdClas() {
        return dClas;
    }

    public void setdClas(String dClas) {
        this.dClas = dClas;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
