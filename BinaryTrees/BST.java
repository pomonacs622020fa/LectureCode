public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        // We'll also note the number of nodes rooted in this subtree
        private int size;

        public Node(Key key, Value value, int size, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.size = size;
        }

        public Node(Key key, Value value, int size) {
            this(key, value, size, null, null);
        }
    }

    private Node root;

    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        buildString(root, stringBuffer, "", "");
        return stringBuffer.toString();
    }

    private void buildString(Node currentNode, StringBuilder buffer, String prefix, String childPrefix) {
        if (currentNode == null) {
            return;
        }

        // Pre-order style traversal
        buffer.append(prefix + currentNode.value + "," + currentNode.key + " (" + currentNode.size + ")\n");
        if (currentNode.left != null && currentNode.right != null) {
            // (1) Both children
            buildString(currentNode.left, buffer, childPrefix + "├── ", childPrefix + "│   ");
            buildString(currentNode.right, buffer, childPrefix + "└── ", childPrefix + "    ");
        } else {
            // (2) Single or no children
            buildString(currentNode.left, buffer, childPrefix + "└── ", childPrefix + "    ");
            buildString(currentNode.right, buffer, childPrefix + "└── ", childPrefix + "    ");
        }

    }

    public Value get(Key key) {
        // Can also implement recursively
        Node currentNode = root;

        while (currentNode != null) {
            int compareResult = key.compareTo(currentNode.key);
            if (compareResult < 0) {
                // key is less than current key
                currentNode = currentNode.left;
            } else if (compareResult > 0) {
                // key is greater than current key
                currentNode = currentNode.right;
            } else {
                // Found the key
                return currentNode.value;
            }
        }

        // Did not find it
        return null;
    }

    public void put(Key key, Value value) {
        // Can also implement iteratively
        root = put(root, key, value);
    }

    private Node put(Node currentNode, Key key, Value value) {
        // Base case
        if (currentNode == null) {
            return new Node(key, value, 1);
        }

        // Second base case when we are updating a node and not adding
        int compareResult = key.compareTo(currentNode.key);
        if (compareResult == 0) {
            // Found the key (no duplicates allowed here)
            currentNode.value = value;
            return currentNode;
        }

        // Else the two recursive cases
        else if (compareResult < 0) {
            // key is less than current key
            currentNode.left = put(currentNode.left, key, value);
        } else {
            // key is greater than current key
            currentNode.right = put(currentNode.right, key, value);
        }

        int leftSize = currentNode.left == null ? 0 : currentNode.left.size;
        int rightSize = currentNode.right == null ? 0 : currentNode.right.size;
        currentNode.size = 1 + leftSize + rightSize;
        return currentNode;
    }

    public void delete(Key key) {
        // Can also implement iteratively
        root = delete(root, key);
    }

    private Node delete(Node currentNode, Key key) {
        // Base case
        if (currentNode == null) {
            return null;
        }

        // Recursive cases
        int compareResult = key.compareTo(currentNode.key);
        if (compareResult < 0) {
            // key is less than current key
            currentNode.left = delete(currentNode.left, key);
        } else if (compareResult > 0) {
            // key is greater than current key
            currentNode.right = delete(currentNode.right, key);
        } else {
            // Found the key
            if (currentNode.right == null) {
                // (1) Single child to the left OR no children
                return currentNode.left;
            } else if (currentNode.left == null) {
                // (2) Single child to the right
                return currentNode.right;
            } else {
                // (3) Replace with successor
                Node successor = currentNode.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                currentNode.right = delete(currentNode.right, successor.key);
                currentNode.value = successor.value;
                currentNode.key = successor.key;
            }
        }

        int leftSize = currentNode.left == null ? 0 : currentNode.left.size;
        int rightSize = currentNode.right == null ? 0 : currentNode.right.size;
        currentNode.size = 1 + leftSize + rightSize;
        return currentNode;
    }

    public static void main(String[] args) {

        BST<Integer, Integer> tree = new BST<>();
        Integer[] ints = { 46, 34, 70, 11, 44, 52, 10, 19, 36, 45, 51 };
        for (Integer i : ints) {
            tree.put(i, i);
        }
        System.out.print("Initial tree:\n " + tree);

        // Test deleting node with no children
        tree.delete(51);
        System.out.print("\nAfter deleting 51:\n" + tree);

        // Test deleting node with single child
        tree.delete(70);
        System.out.print("\nAfter deleting 70:\n" + tree);

        // Test deleting node with single child
        tree.delete(34);
        System.out.print("\nAfter deleting 34:\n" + tree);

        // Test deleting root
        tree.delete(46);
        System.out.print("\nAfter deleting 34:\n" + tree);

        BST<NotComparable, String> bst2 = new BST<>();
        bst2.put(new NotComparable("hello"), "some other string");
        System.out.println(bst2);
    }
}
