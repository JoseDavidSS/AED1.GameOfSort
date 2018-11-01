package Logic.Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {

    @Test
    void add() {
        BTree<String> bt = new BTree<>();
        bt.add("Pablo");
        bt.add("Byron");
        bt.add("Isaac");
        assertEquals(3, bt.size());
    }

    @Test
    void remove() {
        BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        bt.remove("Jeff");
        assertEquals(false, bt.contains("Jeff"));
    }

    @Test
    void clear() {
        BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        bt.clear();
        assertEquals("Tree has no nodes.", bt.toString());

    }

    @Test
    void contains() {
        BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        assertEquals(true, bt.contains("Drani"));
    }

    @Test
    void size() {
        BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        assertEquals(3, bt.size());
    }

}