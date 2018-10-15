import Game.GameUtil;
import Logic.Trees.AVLTree;
import Logic.Trees.BTree;
import Logic.Trees.BinaryTree;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
//        BinaryTree bt = new BinaryTree();
//        bt.add(1);
//        bt.add(2);
//        bt.add(3);
//        bt.add(4);
//        bt.add(5);
//        bt.add(6);
//        bt.add(7);
//
//        AVLTree tree = new AVLTree();
//
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);
//
//        /*
//             30
//            /  \
//          20   40
//         /  \     \
//        10  25    50
//        */
//        System.out.println("Preorder traversal" +
//                " of constructed tree is : ");
//        tree.preOrder(tree.root);
//
//        String name = GameUtil.generateName();
//        System.out.println();
//        System.out.println("Random dragon name is: " + name);
        BTree<String, String> st = new BTree<String, String>();

        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");


        System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
        System.out.println("apple.com:         " + st.get("www.apple.com"));
        System.out.println("ebay.com:          " + st.get("www.ebay.com"));
        System.out.println("dell.com:          " + st.get("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }
}