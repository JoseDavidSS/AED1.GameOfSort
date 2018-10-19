package Logic.Lists;


import Game.Dragon;

//Esta lista es temporal mientras apu y chus suben sus partes
public class DragonList {

    public DragonNode head;
    private int large;
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
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public void addEnemy(Dragon dragon){
        if (this.head == null){
            this.head = new DragonNode(dragon);
            this.large++;
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

    public void print() {
        if (this.getLarge()>0) {
            for (int a = 0; a < this.large; a++) {
                System.out.println(getDragon(a).getRechargeSpeed());
            }
            System.out.println("--------------------------");
        }
    }

    public Dragon getDragon(int index){
        DragonNode tmp = this.head;
        for(int a = 0; a< index;a++){
            tmp = tmp.next;
        }
        return tmp.getDragon();
    }

    public void setDragon(int index, Dragon dragon) {
        if (this.large - 1 < index) {
            System.out.println("IndexOutOfRange");
        } else {
            DragonNode tmp = this.head;
            for (int a = 0; a < index; a++) {
                tmp = tmp.next;
            }
            tmp.setDragon(dragon);
        }
    }

    public void swap(int minIndex, int i) {
        Dragon temp = this.getDragon(minIndex);
        this.setDragon(minIndex, this.getDragon(i));
        this.setDragon(i, temp);
    }

    public void selectionSort() {
        if (this.getLarge() >= 1) {
            for (int a = 0; a < this.large - 1; a++) {
                int minIndex = a;
                for (int j = a + 1; j < this.large; j++)
                    if (this.getDragon(j).getAge() < this.getDragon(minIndex).getAge())
                        minIndex = j;
                swap(minIndex, a);
            }
        }
    }

    public void insertionSort(){
        if (this.getLarge()>0){
            int in;
            int out;
            for(out = 1; out < this.getLarge(); out++){
                Dragon temp = this.getDragon(out);
                in = out;
                while(in >= 0 && this.getDragon(in-1).getRechargeSpeed() >= temp.getRechargeSpeed()){
                    this.swap(in, in-1);
                    in --;
                }
                this.setDragon(in, temp);
            }
        }
    }

    public int partition(){
        int pivote = this.getDragon(this.getLarge()-1).getAge();
        int menor = 0;
        int mayor = this.getLarge()-1;
        int i = menor-1;
        int j;
        for(j = menor; j<this.getLarge()-1; j++){
            if(this.getDragon(j).getAge() <= pivote){
                i++;
                this.swap(i,j);
            }
        }
        this.swap(i+1, mayor);
        return(i+1);
    }

    public void quickSort(int mayor, int menor){
        if(menor<mayor){
            int pi = partition();
            quickSort(pi-1,menor);
            quickSort(mayor, pi+1);

        }
    }



}
