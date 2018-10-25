package Logic.Lists;

public class SendNode {

    public SendNode next;
    private DragonData dragonData;

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
