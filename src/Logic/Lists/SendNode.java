package Logic.Lists;

public class SendNode {

    public SendNode next;
    private DragonData dragonData;

    /**
     * Constructor of the SendNode class.
     * @param dAge integer with the age of the dragon.
     * @param dRSpeed integer with the recharge speed of the dragon.
     * @param dClas string with the class of the dragon.
     * @param posx integer with the x position of the dragon.
     * @param posy integer with the y position of the dragon.
     * @param ID integer with the ID of the dragon.
     * @param name string with the name of the dragon.
     * @param resistence integer with resistence of the dragon.
     */
    public SendNode(int dAge, int dRSpeed, String dClas, int posx, int posy, int ID, String name, int resistence) {
        this.next = null;
        dragonData = new DragonData(dAge, dRSpeed, dClas, posx, posy, ID, name, resistence);
    }

    public SendNode(){}

    public DragonData getDragonData() {
        return dragonData;
    }

    public void setDragonData(DragonData dragonData) {
        this.dragonData = dragonData;
    }
}
