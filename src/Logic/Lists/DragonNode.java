package Logic.Lists;

import Game.Dragon;

public class DragonNode {

    public DragonNode next;
    private Dragon dragon;

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
