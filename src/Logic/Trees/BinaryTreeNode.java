package Logic.Trees;

public class BinaryTreeNode {

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    /**
     * Constructor of the BinaryTreeNode class.
     * @param value integer with value that the node saves.
     */
    BinaryTreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

}
