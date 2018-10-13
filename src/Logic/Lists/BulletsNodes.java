package Logic.Lists;

import Game.Attack;

public class BulletsNodes {

    public BulletsNodes next;
    private Attack attack;

    public BulletsNodes(Attack attack){
        this.attack = attack;
        this.next = null;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }
}
