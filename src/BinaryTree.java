public class BinaryTree {
    BinaryTreeNode root;

    /**
     * Calls the internal method to add a value to the Binary Tree.
     * @param value int
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Adds a value to the tree recursively
     * @param current Node where addition starts (usually root)
     * @param value int
     * @return Modified BinaryTreeNode
     */
    private BinaryTreeNode addRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }


    /**
     * Calls the internal method to check if a node is in the tree.
     * @param value int
     * @return
     */
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    /**
     * Checks if the node exists on the tree recursively
     * @param current Node where check starts (usually root)
     * @param value int
     * @return boolean
     */
    private boolean containsNodeRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    /**
     * Calls internal method to delete a node.
     * @param value int to delete
     */
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    /**
     * Deletes an element from the tree.
     * @param current Node where analysis starts from. (usually root)
     * @param value int to delete
     * @return Modified BinaryTreeNode
     */
    private BinaryTreeNode deleteRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    /**
     * Finds smallest value in tree
     * @param root Node where analysis starts from (usually root)
     * @return int
     */
    private int findSmallestValue(BinaryTreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

}
