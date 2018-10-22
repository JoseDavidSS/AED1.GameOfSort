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

    public void print() {
        if (this.getLarge()>0) {
            for (int a = 0; a < this.large; a++) {
                System.out.println(getDragon(a).getRechargeSpeed());
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * Prints the list values.
     * @return String.
     */
    public String printL() {
        DragonNode node = head;
        String result = "[";
        while (node != null) {
            if (node.next != null) {
                result += node.getDragon() + ",";
            } else {
                result += node.getDragon();
            }
            node = node.next;
        }
        return result + "]";
    }


    public Dragon getDragon(int index){
        DragonNode tmp = this.head;
        for(int a = 0; a< index;a++){
            tmp = tmp.next;
        }
        return tmp.getDragon();
    }

    public DragonNode getDragonNode(int index) {
        DragonNode tmp = this.head;
        for(int a = 0; a< index;a++){
            tmp = tmp.next;
        }
        return tmp;
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

    public DragonList getChunk(int start, int end) {
        DragonNode startDragon = this.getDragonNode(start);
        DragonNode endDragon = this.getDragonNode(end);
        DragonList result = new DragonList();
        while (startDragon != endDragon) {
            result.addEnemy(startDragon.getDragon());
            startDragon = startDragon.next;
        }
        return result;
    }

    public static void binaryGUI(int start, int end, int startingX) {
        DragonList list = DragonList.getInstance();
        DragonList current10 = list.getChunk(start, end);
        DragonNode node = current10.head;
        int leftx = 0;
        double lefty = 0;
        int rightx = 0;
        double righty = 0;
        int switchSide = 0;

        while (node != null) {
            Dragon currentDragon = node.getDragon();
            System.out.println(currentDragon.getClas());
            node = node.next;
        }
        node = current10.head;

        while (node != null) {
            Dragon currentDragon = node.getDragon();
            if (currentDragon.getClas().equals("Commander")) {
                currentDragon.setPosx(startingX);
                currentDragon.setTranslateY(200);
                leftx = currentDragon.getPosx() + 50;
                lefty = currentDragon.getTranslateY() + 50;
                rightx = currentDragon.getPosx() + 50;
                righty = currentDragon.getTranslateY() - 50;
                break;
            }
            node = node.next;
        }
        node = current10.head;

        while (node != null) {
            Dragon currentDragon = node.getDragon();
            if (currentDragon.getClas().equals("Captain")) {
                if (switchSide == 0) {
                    currentDragon.setPosx(leftx);
                    currentDragon.setTranslateY(lefty);
                    leftx += 50;
                    lefty += 50;
                    switchSide = 1;
                } else {
                    currentDragon.setPosx(rightx);
                    currentDragon.setTranslateY(righty);
                    rightx += 50;
                    righty -= 50;
                    switchSide = 0;
                }
            }
            node = node.next;
        }

        node = current10.head;

        while (node != null) {
            Dragon currentDragon = node.getDragon();
            if (currentDragon.getClas().equals("Infantry")) {
                if (leftx == rightx) {
                    if (switchSide == 0) {
                        currentDragon.setPosx(leftx);
                        currentDragon.setTranslateY(lefty);
                        leftx += 50;
                        lefty += 50;
                        switchSide = 1;
                    } else {
                        currentDragon.setPosx(rightx);
                        currentDragon.setTranslateY(righty);
                        rightx += 50;
                        righty -= 50;
                        switchSide = 0;
                    }
                } else if (leftx > rightx) {
                    currentDragon.setPosx(rightx);
                    currentDragon.setTranslateY(righty);
                    rightx += 50;
                    righty -= 50;
                    switchSide = 0;
                } else {
                    currentDragon.setPosx(leftx);
                    currentDragon.setTranslateY(lefty);
                    leftx += 50;
                    lefty += 50;
                    switchSide = 1;
                }
            }
            node = node.next;
        }
    }

    public static void binaryGUIHelper() {
        int startingX = 600;
        binaryGUI(0, 10, startingX);
//        binaryGUI(10, 20, startingX + 600);
//        binaryGUI(20, 30, startingX + 1200);
//        binaryGUI(30, 40, startingX + 1800);
//        binaryGUI(40, 50, startingX + 2400);
//        binaryGUI(50, 60, startingX + 3000);
//        binaryGUI(60, 70, startingX + 3600);
//        binaryGUI(70, 80, startingX + 4200);
//        binaryGUI(80, 90, startingX + 4800);
//        binaryGUI(90, 99, startingX + 5400);
    }

}
