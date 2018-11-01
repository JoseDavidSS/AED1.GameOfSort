package Logic.Lists;

import Game.Dragon;
import Game.GameUtil;
import Logic.Trees.AVLTree;
import Logic.Trees.AVLTreeNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class SendList {

    public SendNode head;
    private int large;
    private int leftest;

    /**
     * Constructor of the SendList class.
     */
    public SendList(){
        this.head = null;
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

    /**
     * Method to add a node with the data of the dragon to the list.
     * @param dAge integer with the age of the dragon.
     * @param dRSpeed integer with the recharge speed of the dragon.
     * @param dClas string with the class of the dragon.
     * @param posx integer with the x position of the dragon.
     * @param posy integer with the y position of the dragon.
     * @param ID integer with the ID if the dragon.
     * @param name string with the name of the dragon.
     * @param resistence integer with the resistence of the dragon.
     */
    public void addData(int dAge, int dRSpeed, String dClas, int posx, int posy, int ID, String name, int resistence){
        if (this.head == null){
            this.head = new SendNode(dAge, dRSpeed, dClas, posx, posy, ID, name, resistence);
            this.large++;
            this.leftest = posx;
        }else{
            SendNode tmp = this.head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new SendNode(dAge, dRSpeed, dClas, posx, posy, ID, name, resistence);
            this.large++;
            if (posx < this.leftest){
                this.leftest = posx;
            }
        }
    }

    /**
     * Method to print the age of each dragon.
     */
    public void printAge(){
        SendNode tmp = this.head;
        while(tmp != null){
            System.out.println(tmp.getDragonData().getdAge());
            tmp = tmp.next;
        }
        System.out.println("*********");
    }

    /**
     * Method to print the class of each dragon.
     */
    public void printFamily(){
        SendNode tmp = this.head;
        while(tmp != null){
            System.out.println(tmp.getDragonData().getdClas());
            tmp = tmp.next;
        }
        System.out.println("*********");
    }

    /**
     * Method to print the recharge speed of each dragon.
     */
    public void printRSpeed(){
        SendNode tmp = this.head;
        while(tmp != null){
            System.out.println(tmp.getDragonData().getdRSpeed());
            tmp = tmp.next;
        }
        System.out.println("*********");
    }

    public void printID(){
        SendNode tmp = this.head;
        while (tmp != null){
            System.out.println(tmp.getDragonData().getID());
            tmp = tmp.next;
        }
        System.out.println("*****************");
    }

    public void printX(){
        SendNode tmp = this.head;
        int i = 1;
        while (tmp != null){
            System.out.println(i + ": " + tmp.getDragonData().getPosx() + ", " + tmp.getDragonData().getPosy());
            tmp = tmp.next;
            i++;
        }
        System.out.println("*****************");
    }

    /**
     * Method to use the selection sort to reorganize the list.
     */
    public void selectionSort() {
        if (this.getLarge() >= 1) {
            for (int a = 0; a < this.large - 1; a++) {
                int minIndex = a;
                for (int j = a + 1; j < this.large; j++)
                    if (this.getDragonData(j).getdAge() < this.getDragonData(minIndex).getdAge())
                        minIndex = j;
                this.swap(minIndex, a);
            }
            this.arrange();
        }
    }

    /**
     * Method to use the insertion sort to reorganize the list.
     */
    public void insertionSort(){
        if (this.getLarge()>0){
            int in;
            int out;
            for(out = 1; out < this.getLarge(); out++){
                DragonData tmp = this.getDragonData(out);
                in = out;
                while(in >= 0 && this.getDragonData(in-1).getdRSpeed() >= tmp.getdRSpeed()){
                    this.swap(in, in-1);
                    in --;
                }
                this.setDragonData(in, tmp);
            }
            this.arrange();
        }
    }

    /**
     * Method to use the quick sort to reorganize the list.
     * @param max integer with the lenght of the list.
     * @param min integer with the number 0 or 1.
     */
    /**
     * QuickSort by age
     */
    public void quickSort(){
        quickSort_aux( 0, this.getLarge()-1);
    }

    private void quickSort_aux( int low, int high){
        // Check for empty or null array
        if (this == null || this.getLarge() == 0){
            return;
        }
        if (low >= high){
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = this.getDragonData(middle).getdAge(); //remember to add get age

        // Make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j)
        {
            // Check until all values on left side array are lower than pivot
            while (this.getDragonData(i).getdAge() < pivot) {
                i++;
            }
            // Check until all values on left side array are greater than pivot
            while (this.getDragonData(j).getdAge() > pivot) {
                j--;
            }
            // Comparing values from both side of lists to swap them if necessary
            if (i <= j)
            {
                swap (i, j);
                i++;
                j--;
            }
        }
        // Sort the subarrays recursively
        if (low < j){
            quickSort_aux(low, j);
        }
        if (high > i){
            quickSort_aux(i, high);
        }

    }

    /**
     * Method to swap data between SendNodes.
     * @param minIndex integer with the minimun index.
     * @param i integer with the index of the dragon.
     */
    public void swap(int minIndex, int i) {
        DragonData tmp = this.getDragonData(minIndex);
        this.setDragonData(minIndex, this.getDragonData(i));
        this.setDragonData(i, tmp);
    }

    /**
     * Method to get the DragonData of a node.
     * @param index integer to get to the node that contains the data.
     * @return the data of the dragon.
     */
    public DragonData getDragonData(int index){
        SendNode tmp = this.head;
        for(int a = 0; a< index;a++){
            tmp = tmp.next;
        }
        return tmp.getDragonData();
    }

    /**
     * Method to set the DragonData to a node.
     * @param index integer to get to the node that will have the data.
     * @param dragon data of the dragon.
     */
    public void setDragonData(int index, DragonData dragon) {
        if (this.large - 1 < index) {
            System.out.println("IndexOutOfRange");
        } else {
            SendNode tmp = this.head;
            for (int a = 0; a < index; a++) {
                tmp = tmp.next;
            }
            tmp.setDragonData(dragon);
        }
    }

    /**
     * Method to modify the x and y positions of each dragon .
     */
    public void arrange(){
        SendNode tmp = this.head;
        int y = 15;
        int x = this.leftest;
        int i = 0;
        while (tmp != null){
            DragonData sub_tmp = tmp.getDragonData();
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
     * Method to get the node to change.
     * @param index integer with the node that will be used.
     * @return the node with the data.
     */
    public SendNode getSendNode(int index) {
        SendNode tmp = this.head;
        for(int a = 0; a< index;a++){
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * Organizes alive dragons in Binary Tree form.
     */
    public SendList binaryGUIHelper() {
        int length = this.large;
        ArrayList pos = this.separate(length);
        // If there are less than 10 dragons alive.
        if (length < 10) {
            return this.binaryGUI(0, length, this.leftest);
        }else {
            int i = 0;
            int xStart = 0;
            SendList newsl = new SendList();
            SendList s;
            // Iterates binaryGUI in groups of 10.
            while (i < pos.size()) {
                if ((int) pos.get(i + 1) == 404) {
                    break;
                }
                s = this.binaryGUI((int) pos.get(i), (int) pos.get(i + 1), xStart + this.leftest);
                SendNode tmp = s.head;
                while (tmp != null){
                    DragonData sub_tmp = tmp.getDragonData();
                    newsl.addData(sub_tmp.getdAge(), sub_tmp.getdRSpeed(), sub_tmp.getdClas(), sub_tmp.getPosx(), sub_tmp.getPosy(), sub_tmp.getID(), sub_tmp.getName(), sub_tmp.getResistence());
                    tmp = tmp.next;
                }
                xStart += 800;
                i++;
            }
            return newsl;
        }
    }

    /**
     * Organizes a chunk of dragons in a Binary Tree form in the GUI.
     * @param start start of chunk
     * @param end end of chunk
     * @param startingX start x position (of the first dragon/root)
     */
    public SendList binaryGUI(int start, int end, int startingX) {
        // Initializes variables, gets chunk of list to organize.
        SendList current10 = this.getChunk(start, end);
        SendNode node = current10.head;
        int switchSide = 0;

        // Prints the dragon classes.
//        while (node != null) {
//            Dragon currentDragon = node.getDragon();
//            System.out.println(currentDragon.getClas());
//            node = node.next;
//        }
//        node = current10.head;

        // Takes the first dragon and makes it the root. Modifies x and y positions of next dragons.
        DragonData firstDragon = node.getDragonData();
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
            DragonData currentDragon = node.getDragonData();
            if (currentDragon.getdClas().equals("Captain")) {
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
            DragonData currentDragon = node.getDragonData();
            if (currentDragon.getdClas().equals("Infantry")) {
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
        return current10;
    }

    /**
     * Gets a chunk of the game's DragonList instance.
     * @param start start of chunk
     * @param end end of chunk
     * @return DragonList
     */
    public SendList getChunk(int start, int end) {
        SendNode startDragon = this.getSendNode(start);
        SendNode endDragon = this.getSendNode(end);
        SendList result = new SendList();
        while (startDragon != endDragon) {
            DragonData dragonData = startDragon.getDragonData();
            result.addData(dragonData.getdAge(), dragonData.getdRSpeed(), dragonData.getdClas(), dragonData.getPosx(), dragonData.getPosy(), dragonData.getID(), dragonData.getName(), dragonData.getResistence());
            startDragon = startDragon.next;
        }
        return result;
    }

    /**
     * Generates ArrayList in groups of ten.
     * @param length length of list
     * @return ArrayList
     */
    public ArrayList separate(int length) {
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


    /**
     * Organizes dragons in AVL Tree form in GUI.
     * @param start start of DragonList to organize.
     * @param end end of DrgonsList to organize
     * @param startingX starting x position (of dragon in root position)
     */
    public SendList AVLGUI(int start, int end, int startingX) {
        SendList currentChunk = this.getChunk(start, end);
        AVLTree tree = instanceToAVL(currentChunk);
        tree.preOrder(tree.root);

        // Places dragon in root position and defines left and right's x and y positions.
        DragonData firstDragon = ageToDragon(tree.root.getKey(), currentChunk);
        firstDragon.setPosx(startingX);
        firstDragon.setPosy(250);
        int leftx = firstDragon.getPosx() + 60;
        int lefty = firstDragon.getPosy() + 90;
        int rightx = firstDragon.getPosx() + 60;
        int righty = firstDragon.getPosy() - 90;

        // Recursively modifies dragon positions.
        this.placeLeft(tree.root.left, leftx, lefty, currentChunk);
        this.placeRight(tree.root.right, rightx, righty, currentChunk);
        return currentChunk;
    }

    /**
     * Organizes alive dragons in AVL Tree form.
     */
    public SendList AVLGUIHelper(){
        int length = this.large;
        ArrayList pos = separate(length);
        // If there are less than 10 dragons alive.
        if (length < 10) {
            return this.AVLGUI(0, length, this.leftest);
        } else {
            int i = 0;
            int xStart = 0;
            SendList newsl = new SendList();
            SendList s;
            // Iterates AVLGUI in groups of 10.
            while (i < pos.size()) {
                if ((int) pos.get(i + 1) == 404) {
                    break;
                }
                s = this.AVLGUI((int) pos.get(i), (int) pos.get(i + 1), xStart + this.leftest);
                SendNode tmp = s.head;
                while (tmp != null){
                    DragonData sub_tmp = tmp.getDragonData();
                    newsl.addData(sub_tmp.getdAge(), sub_tmp.getdRSpeed(), sub_tmp.getdClas(), sub_tmp.getPosx(), sub_tmp.getPosy(), sub_tmp.getID(), sub_tmp.getName(), sub_tmp.getResistence());
                    tmp = tmp.next;
                }
                xStart += 800;
                i++;
            }
            return newsl;
        }
    }

    /**
     * Recursively modifies dragon position in left child node of AVL Tree.
     * @param node node where the positioning starts from
     * @param x x position of dragon
     * @param y y position of dragon
     * @param chunk list of dragons to place
     */
    public void placeLeft(AVLTreeNode node, int x, int y, SendList chunk) {
        if (node != null) {
            DragonData currentDragon = ageToDragon(node.getKey(), chunk);
            currentDragon.setPosx(x);
            currentDragon.setPosy(y);
            if (node.right != null) {
                this.placeRight(node.right, x + 60, y - 90, chunk);
            }
            this.placeLeft(node.left, x + 60, y + 90, chunk);
        }
    }

    /**
     * Recursively modifies dragon position in right child node of AVL Tree.
     * @param node node where the positioning starts from
     * @param x x position of dragon
     * @param y y position of dragon
     * @param chunk list of dragons to place
     */
    public void placeRight(AVLTreeNode node, int x, int y, SendList chunk) {
        if (node != null) {
            DragonData currentDragon = ageToDragon(node.getKey(), chunk);
            currentDragon.setPosx(x);
            currentDragon.setPosy(y);
            if (node.left != null) {
                this.placeLeft(node.left, x + 60, y + 90, chunk);
            }
            this.placeRight(node.right, x + 60, y - 90, chunk);
        }
    }

    /**
     * Converts a list of dragons in AVL Tree class type tree
     * @param chunk list of dragons to insert in AVL Tree
     * @return AVL Tree of the dragons's ages
     */
    public AVLTree instanceToAVL(SendList chunk) {
        AVLTree result = new AVLTree();
        SendNode node = chunk.head;
        while (node != null) {
            result.root = result.insert(result.root, node.getDragonData().getdAge());
            node = node.next;
        }
        return result;
    }

    /**
     * Takes an age and gets the Dragon with that age. Happy Birthday Dragons!
     * @param age int age of the dragon you want, basically
     * @param list DragonList you want to read
     * @return Dragon with that age
     */
    public DragonData ageToDragon(int age, SendList list) {
        SendNode node = list.head;
        DragonData result = list.head.getDragonData();
        while (node != null) {
            if (node.getDragonData().getdAge() == age) {
                result = node.getDragonData();
                break;
            }
            node = node.next;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        int i = 0;
        int y = 15;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        int id = 1;
        SendList sl = new SendList();
        while (i != 20){
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first){
                first = true;
                clas = "Commander";
                resistence = 2;
            }
            if (resistence < 2){
                clas = "Infantry";
            }
            sl.addData(age, rSpeed, clas, x, y, id, dragonName, resistence);
            y += 70;
            if (i % 9 == 0 && i != 0){
                y = 15;
                if (!fLine){
                    x += 400;
                    fLine = true;
                }
                else{
                    x += 400;
                }
            }
            i++;
            id++;
        }
        sl.printX();
        sl = sl.AVLGUIHelper();
        sl.printX();
    }
}
