package Logic;

public class AVLTree {
    public AVLTreeNode root;

    /**
     * Gets maximum number of two int.
     * @param a int
     * @param b int
     * @return int
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Gets height from tree.
     * @param N Logic.AVLTreeNode
     * @return int Height of tree
     */
    public int getHeight(AVLTreeNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    /**
     * Rotates the tree to the right.
     * @param y Logic.AVLTreeNode
     * @return Modified Logic.AVLTree
     */
    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * Rotates the tree to the left.
     * @param x Logic.AVLTreeNode
     * @return Modified Logic.AVLTree
     */
    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }


    /**
     * Gets balance factor of node N.
     * @param N Logic.AVLTreeNode
     * @return int
     */
    public int getBalance(AVLTreeNode N) {
        if (N == null)
            return 0;

        return getHeight(N.left) - getHeight(N.right);
    }

    /**
     * Inserts Node in tree and adjusts it correspondingly
     * @param node Logic.AVLTreeNode
     * @param key int
     * @return Logic.AVLTreeNode
     */
    public AVLTreeNode insert(AVLTreeNode node, int key) {
        if (node == null)
            return (new AVLTreeNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }


    /**
     * Prints the preorder traversal of the tree
     * @param node Node from where the printing starts.
     */
    public void preOrder(AVLTreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }




}
