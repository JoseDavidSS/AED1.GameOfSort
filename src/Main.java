import Game.Dragon;
import Game.GameUtil;
import Logic.Lists.DragonList;
import Logic.Trees.AVLTree;
import Logic.Trees.BTree;
import Logic.Trees.BinaryTree;

import java.io.IOException;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Main {
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

       /* BTree<String> bt = new BTree<>();
        bt.add("Drani");
        bt.add("Smaug");
        bt.add("Jeff");
        bt.add("Schmidt");
        bt.add("Laura");
        bt.add("Yamir");
        bt.add("Ale");
        bt.add("Emma");
        bt.add("Lion");
        bt.add("Lady");
        bt.add("Sansa");
        bt.add("Stark");
        bt.add("Drogon");
        bt.add("Lorde");
        System.out.println(bt);*/
        /*int Dragons = 5;
        int i = 0;
        int y = 5;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        while (i != Dragons){
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first){
                first = true;
                clas = "Commander";
            }
            if (resistence < 2){
                clas = "Infantry";
            }
            Dragon dragon = new Dragon(resistence, dragonName, rSpeed, age, clas, x, y, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
            DragonList.getInstance().addEnemy(dragon);
            y += 70;
            if (i % 10 == 0 && i != 0){
                y = 5;
                if (!fLine){
                    x += 800;
                    fLine = true;
                }
                else{
                    x += 500;
                }
            }
            i++;
        }
        DragonList.getInstance().quickSort(Dragons,0);
        DragonList.getInstance().print();
    }*/
    }
}
