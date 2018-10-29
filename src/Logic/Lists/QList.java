package Logic.Lists;

public class QList {

    public class QNode {
        public QNode next;
        public int value;

        public QNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

    }

    public int length = 0;
    public QNode head;

    /**
     * Appends value to list.
     * @param value value type depends on list type
     */
    public void appe(int value) {
        length += 1;
        if (head == null) {
            head = new QNode(value);
        } else {
            QNode tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new QNode(value);
        }
    }

    public int getLength() {
        return this.length;
    }

    /**
     * Access the list data through indexes from 0 to list length - 1.
     * @param i Index you want to access.
     * @return Logic.List.
     */
    public int index(int i) {
        QNode node = head;
        int result = 0;
        int index = 0;
        while (node != null) {
            if (index == i) {
                result = node.getValue();
                break;
            }
            node = node.next;
            index += 1;
        }
        return result;
    }

    /**
     * Access the list data through indexes from 0 to list length - 1.
     * @param i Index you want to access.
     * @return Logic.List.
     */
    private QNode indexNode(int i) {
        QNode node = head;
        QNode result = null;
        int index = 0;
        while (node != null) {
            if (index == i) {
                result = node;
                break;
            }
            node = node.next;
            index += 1;
        }
        return result;
    }

    /**
     * Replaces element in index with new element.
     * @param index index you want to replace
     * @param element value you want to replace it with
     */
    public void setIndex(int index, int element) {
        QNode toReplace = this.indexNode(index);
        toReplace.value = element;
    }

    /**
     * Prints the list values.
     * @return String.
     */
    public String printL() {
        QNode node = head;
        String result = "[";
        while (node != null) {
            if (node.next != null) {
                result += node.getValue() + ",";
            } else {
                result += node.getValue();
            }
            node = node.next;
        }
        return result + "]";
    }

}
