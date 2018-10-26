package Logic.Trees;

public class AVLTreeNode {

    int key, height;
    public AVLTreeNode left;
    public AVLTreeNode right;

    /**
     * Constructor of the AVLTreeNode class.
     * @param d integer with the key of the tree.
     */
    AVLTreeNode(int d) {
        this.key = d;
        this.height = 1;
    }

    public int getKey() {
        return this.key;
    }

}