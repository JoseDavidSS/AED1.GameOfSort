package Logic.Lists;

import Game.Dragon;

import java.util.ArrayList;

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
        if(menor < mayor){
            int pi = partition();
            quickSort(pi-1,menor);
            quickSort(mayor, pi+1);
        }
    }

    public void arrange(){
        DragonNode tmp = this.head;
        int y = 15;
        int x = this.leftest;
        int i = 0;
        while (tmp != null){
            Dragon sub_tmp = tmp.getDragon();
            sub_tmp.setPosx(x);
            sub_tmp.setPosy(y);
            y += 70;
            if (i % 9 == 0 && i != 0){
                y = 15;
                x += 400;
            }
            i++;
            tmp = tmp.next;
        }
    }

    /**
     * Gets a chunk of the game's DragonList instance.
     * @param start start of chunk
     * @param end end of chunk
     * @return DragonList
     */
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

    /**
     * Organizes a chunk of dragons in a Binary Tree form in the GUI.
     * @param start start of chunk
     * @param end end of chunk
     * @param startingX start x position (of the first dragon/root)
     */
    public static void binaryGUI(int start, int end, int startingX) {
        // Initializes variables, gets chunk of list to organize.
        DragonList list = DragonList.getInstance();
        DragonList current10 = list.getChunk(start, end);
        DragonNode node = current10.head;
        int switchSide = 0;

        // Prints the dragon classes.
//        while (node != null) {
//            Dragon currentDragon = node.getDragon();
//            System.out.println(currentDragon.getClas());
//            node = node.next;
//        }
//        node = current10.head;

        // Takes the first dragon and makes it the root. Modifies x and y positions of next dragons.
        Dragon firstDragon = node.getDragon();
        firstDragon.setPosx(startingX);
        firstDragon.setPosy(250);
        int leftx = firstDragon.getPosx() + 50;
        int lefty = firstDragon.getPosy() + 80;
        int rightx = firstDragon.getPosx() + 50;
        int righty = firstDragon.getPosy() - 80;
        int putDragons = 1;
        node = node.next;

        // Organizes captains only.
        while (node != null) {
            Dragon currentDragon = node.getDragon();
            if (currentDragon.getClas().equals("Captain")) {
                if (putDragons > 4 && putDragons < 7) {
                    if (switchSide == 0) {
                        leftx -= 50;
                        lefty -= 200;
                    } else {
                        rightx -= 50;
                        righty += 200;
                    }
                }
                if (switchSide == 0) {
                    currentDragon.setPosx(leftx);
                    currentDragon.setPosy(lefty);
                    leftx += 50;
                    lefty += 80;
                    switchSide = 1;
                    putDragons ++;
                } else {
                    currentDragon.setPosx(rightx);
                    currentDragon.setPosy(righty);
                    rightx += 50;
                    righty -= 80;
                    switchSide = 0;
                    putDragons ++;
                }
            }
            node = node.next;
        }

        node = current10.head.next;

        // Same thing but with Infantry.
        while (node != null) {
            Dragon currentDragon = node.getDragon();
            if (currentDragon.getClas().equals("Infantry")) {
                if (putDragons > 4 && putDragons < 7) {
                    if (switchSide == 0) {
                        leftx -= 50;
                        lefty -= 200;
                    } else {
                        rightx -= 50;
                        righty += 200;
                    }
                }
                if (switchSide == 0) {
                    currentDragon.setPosx(leftx);
                    currentDragon.setPosy(lefty);
                    leftx += 50;
                    lefty += 80;
                    switchSide = 1;
                    putDragons ++;
                } else {
                    currentDragon.setPosx(rightx);
                    currentDragon.setPosy(righty);
                    rightx += 50;
                    righty -= 80;
                    switchSide = 0;
                    putDragons ++;
                }
            }
            node = node.next;
        }
    }

    /**
     * Organizes alive dragons in Binary Tree form.
     */
    public static void binaryGUIHelper() {
        DragonList dragons = DragonList.getInstance();
        int length = dragons.large;
        ArrayList pos = separate(length);

        // If there are less than 10 dragons alive.
        if (length < 10) {
            binaryGUI(0, length, dragons.getLeftest());
        } else {
            int i = 0;
            int xStart = 0;
            // Iterates binaryGUI in groups of 10.
            while (i < pos.size()) {
                if ((int) pos.get(i + 1) == 404) {
                    break;
                }
                binaryGUI((int) pos.get(i), (int) pos.get(i + 1), xStart + dragons.getLeftest());
                xStart += 800;
                i++;
            }
        }
    }

    /**
     * Generates ArrayList in groups of ten.
     * @param length length of list
     * @return ArrayList
     */
    public static ArrayList separate(int length) {
        int count = 0;
        int multiplier = 1;
        ArrayList result = new ArrayList();
        result.add(0);
        while (count != length) {
            if (count % 10 == 0) {
                result.add(multiplier * 10);
                multiplier ++;
            }
            count ++;
        }
        if (length % 10 != 0) {
            int listLen = result.size();
            result.remove(listLen - 1);
            result.add((length % 10 + 10 * multiplier) - 20);
        }
        result.add(404);
        return result;
    }

}
