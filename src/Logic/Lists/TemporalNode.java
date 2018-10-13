package Logic.Lists;

import Game.Dragon;

public class TemporalNode {

    public TemporalNode next;
    private Dragon dragon;

    public TemporalNode(Dragon dragon){
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
