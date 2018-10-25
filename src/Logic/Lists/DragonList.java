package Logic.Lists;

import Game.Dragon;

public class DragonList {

    public DragonNode head;

    private int large;
    private int leftest;
    private static DragonList list = new DragonList();

    public static DragonList getInstance(){
        return list;
    }

    public static void setInstance(DragonList list1){
        list = list1;
    }

    public static void reset(){
        list = new DragonList();
    }

    private DragonList(){
        this.head = null;
        this.large = 0;
        this.leftest = 0;
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getLeftest() {
        return leftest;
    }

    public void setLeftest(int leftest) {
        this.leftest = leftest;
    }

    public void addEnemy(Dragon dragon){
        if (this.head == null){
            this.head = new DragonNode(dragon);
            this.large++;
            this.leftest = dragon.getPosx();
        }else{
            DragonNode tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new DragonNode(dragon);
            this.large++;
        }
    }

    public void deleteEnemy(Dragon dragon){
        if (this.head.getDragon() == dragon){
            this.head = this.head.next;
            this.large--;
            this.leftest = this.head.getDragon().getPosx();
        }else{
            DragonNode tmp = this.head;
            while (tmp.next != null){
                if (tmp.next.getDragon() == dragon && tmp.next.next == null){
                    tmp.next = null;
                    break;
                }else if(tmp.next.getDragon() == dragon){
                    tmp.next = tmp.next.next;
                    this.large--;
                    break;
                }else{
                    tmp = tmp.next;
                }
            }
        }
    }

    public boolean allReady(){
        if (this.large != 0){
            boolean a = true;
            DragonNode tmp = this.head;
            while (tmp != null){
                Dragon sub_tmp = tmp.getDragon();
                if (sub_tmp.isReadyX() && sub_tmp.isReadyY()){
                    sub_tmp.setReadyX(false);
                    sub_tmp.setReadyY(false);
                    tmp = tmp.next;
                }else{
                    a = false;
                    break;
                }
            }
            return a;
        }else{
            return false;
        }
    }
}
