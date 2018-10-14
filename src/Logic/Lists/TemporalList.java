package Logic.Lists;


import Game.Dragon;

//Esta lista es temporal mientras apu y chus suben sus partes
public class TemporalList {

    public TemporalNode head;
    private int large;
    private static TemporalList list = new TemporalList();

    public static TemporalList getInstance(){
        return list;
    }

    public static void setInstance(TemporalList list1){
        list = list1;
    }

    public static void reset(){
        list = new TemporalList();
    }

    private TemporalList(){
        this.head = null;
        this.large = 0;
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public void addEnemy(Dragon dragon){
        if (this.head == null){
            this.head = new TemporalNode(dragon);
            this.large++;
        }else{
            TemporalNode tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new TemporalNode(dragon);
            this.large++;
        }
    }

    public void deleteEnemy(Dragon dragon){
        if (this.head.getDragon() == dragon){
            this.head = this.head.next;
            this.large--;
        }else{
            TemporalNode tmp = this.head;
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

}
