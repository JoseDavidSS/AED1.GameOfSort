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

    /**
     * Constructor of the DragonData class.
     * @param dAge integer with the age of the dragon.
     * @param dRSpeed integer with the recharge speed of the dragon.
     * @param dClas string with the class of the dragon.
     * @param posx integer with the x position of the dragon.
     * @param posy integer with the y position of the dragon.
     * @param ID integer with the ID of the dragon.
     * @param name string with the name of the dragon.
     * @param resistence integer with the resistence of the dragon.
     */
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

    /**
     * Default constructor of the DragonData class.
     */
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
