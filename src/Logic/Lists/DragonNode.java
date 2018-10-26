package Logic.Lists;

import Game.Dragon;

public class DragonNode {

    public DragonNode next;
    private Dragon dragon;

    /**
     * Constructor of the DragonNode class.
     * @param dragon instance of the dragon that the node will save.
     */
    public DragonNode(Dragon dragon){
        this.next = null;
        this.dragon = dragon;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }
}
