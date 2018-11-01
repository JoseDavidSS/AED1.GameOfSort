package Logic.Lists;

import Logic.Trees.AVLTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SendListTest {

    @Test
    void addData() {
        SendList sendList = new SendList();
        assertEquals(0, sendList.getLarge());
        sendList.addData(12, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        assertEquals(1, sendList.getLarge());
        assertEquals(50, sendList.getLeftest());
        sendList.addData(31, 22, "Commander", 12, 100, 2, "Jose", 2);
        assertEquals(2, sendList.getLarge());
        assertEquals(12, sendList.getLeftest());
        sendList.addData(31, 22, "Commander", 12, 100, 3, "Jose", 2);
        assertEquals(3, sendList.getLarge());
        assertEquals(12, sendList.getLeftest());
    }

    @Test
    void selectionSort() {
        SendList sendList = new SendList();
        sendList.addData(80, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(31, 22, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(900, 22, "Commander", 1, 100, 3, "Jose", 2);
        sendList.addData(145, 22, "Commander", 202, 100, 4, "Jose", 2);
        sendList.addData(2, 22, "Commander", 129, 100, 5, "Jose", 2);
        sendList.addData(462, 22, "Commander", 433, 100, 6, "Jose", 2);
        sendList.addData(864, 22, "Commander", 764, 100, 7, "Jose", 2);
        sendList.addData(456, 22, "Commander", 234, 100, 8, "Jose", 2);
        sendList.addData(765, 22, "Commander", 765, 100, 9, "Jose", 2);
        sendList.addData(77, 22, "Commander", 345, 100, 10, "Jose", 2);
        sendList.addData(777, 22, "Commander", 433, 100, 11, "Jose", 2);
        assertEquals(11, sendList.getLarge());
        sendList.selectionSort();
        assertEquals(2, sendList.head.getDragonData().getdAge());
        assertEquals(1, sendList.head.getDragonData().getPosx());
    }

    @Test
    void insertionSort() {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 65, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(900, 35, "Commander", 1, 100, 3, "Jose", 2);
        sendList.addData(145, 76, "Commander", 202, 100, 4, "Jose", 2);
        sendList.addData(2, 97, "Commander", 129, 100, 5, "Jose", 2);
        sendList.addData(462, 45, "Commander", 433, 100, 6, "Jose", 2);
        sendList.addData(864, 24, "Commander", 764, 100, 7, "Jose", 2);
        sendList.addData(456, 75, "Commander", 234, 100, 8, "Jose", 2);
        sendList.addData(765, 98, "Commander", 765, 100, 9, "Jose", 2);
        sendList.addData(77, 12, "Commander", 345, 100, 10, "Jose", 2);
        sendList.addData(777, 43, "Commander", 433, 100, 11, "Jose", 2);
        assertEquals(11, sendList.getLarge());
        sendList.insertionSort();
        assertEquals(12, sendList.head.getDragonData().getdRSpeed());
        assertEquals(1, sendList.head.getDragonData().getPosx());
    }

    @Test
    void ageToDragon() {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(992, 65, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(12, 65, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(200, 65, "Commander", 12, 100, 2, "Jose", 2);
        assertEquals(sendList.head, sendList.ageToDragon(1, sendList));
        assertEquals(sendList.head.next, sendList.ageToDragon(992, sendList));
        assertEquals(sendList.head.next.next, sendList.ageToDragon(12, sendList));
        assertEquals(sendList.head.next.next.next, sendList.ageToDragon(200, sendList));
    }

    @Test
    void instancetoAVL() {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        AVLTree ages = new AVLTree();
        ages.insert(ages.root, 1);
        ages.insert(ages.root, 100);
        ages.insert(ages.root, 100);
        assertEquals(ages.getHeight(ages.root), sendList.instanceToAVL(sendList).getHeight(ages.root));
    }

    @Test
    void separate() {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(200, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        ArrayList numbers = new ArrayList();
        numbers.add(0);
        numbers.add(10);
        numbers.add(15);
        numbers.add(404);
        assertEquals(numbers, sendList.separate(10));
    }

    @Test
    void getChunk() {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(100, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        SendList manualChunk = new SendList();
        manualChunk.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        manualChunk.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        assertEquals(manualChunk.getLarge(), sendList.getChunk(0, 2).getLarge());
    }
}