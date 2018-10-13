package Logic.Trees;

public class BinaryTree {
    BinaryTreeNode root;

    /**
     * Calls the internal method to add a value to the Binary Tree.
     * @param value int
     */
    public void add(int value) {
        root = add_aux(root, value);
    }

    /**
     * Adds a value to the tree recursively
     * @param current Node where addition starts (usually root)
     * @param value int
     * @return Modified Logic.Trees.BinaryTreeNode
     */
    private BinaryTreeNode add_aux(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }
        if (value < current.value) {
            current.left = add_aux(current.left, value);
        } else if (value > current.value) {
            current.right = add_aux(current.right, value);
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
        return containsNode_aux(root, value);
    }

    /**
     * Checks if the node exists on the tree recursively
     * @param current Node where check starts (usually root)
     * @param value int
     * @return boolean
     */
    private boolean containsNode_aux(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNode_aux(current.left, value)
                : containsNode_aux(current.right, value);
    }

    /**
     * Calls internal method to delete a node.
     * @param value int to delete
     */
    public void delete(int value) {
        root = delete_aux(root, value);
    }

    /**
     * Deletes an element from the tree.
     * @param current Node where analysis starts from. (usually root)
     * @param value int to delete
     * @return Modified Logic.Trees.BinaryTreeNode
     */
    private BinaryTreeNode delete_aux(BinaryTreeNode current, int value) {
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
            current.left = delete_aux(current.left, value);
            return current;
        }
        current.right = delete_aux(current.right, value);
        return current;
    }

    /**
     * Finds smallest value in tree
     * @param root Node where analysis starts from (usually root)
     * @return int
     */
    private int findMin(BinaryTreeNode root) {
        return root.left == null ? root.value : findMin(root.left);
    }

}
