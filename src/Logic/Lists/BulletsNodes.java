package Logic.Lists;

import Game.Attack;

public class BulletsNodes {

    public BulletsNodes next;
    private Attack attack;

    /**
     * Constructor of the BulletsNodes class.
     * @param attack instance of the attack to save.
     */
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
