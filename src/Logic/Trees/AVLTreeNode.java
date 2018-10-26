package Logic.Trees;

public class AVLTreeNode {
    int key, height;
    public AVLTreeNode left;
    public AVLTreeNode right;


    AVLTreeNode(int d) {
        key = d;
        height = 1;
    }

    public int getKey() {
        return this.key;
    }

}