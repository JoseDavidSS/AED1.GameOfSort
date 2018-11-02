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
        bt.add("Jeff");
        bt.add("killme");
        bt.add("Youtube");
        bt.add("pls");
        bt.add("Tyrell");
        bt.add("Rochester");
        bt.add("iPhone");
        bt.add("iPad");
        bt.add("AppleWatch");
        bt.add("GooglePixel");
        bt.add("SurfacePro");
        bt.add("SurfaceBook");
        bt.add("Note7");
        bt.add("explosion");
        assertEquals(17, bt.size());
    }

    @Test
    void remove() {
        BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        bt.add("Yurgen");
        bt.add("Stuff");
        bt.remove("Gamecube");
        bt.remove("Jeff");
        bt.remove("Smaug");
        bt.remove("Stuff");
        assertEquals(false, bt.contains("Jeff"));
        assertEquals(false, bt.contains("Smaug"));
        assertEquals(false, bt.contains("Stuff"));
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