/**
 * BinaryTree
 */
public class BinaryTree<Item> {

    private class Node {
        private Item item;
        private Node left;
        private Node right;

        public Node(Item item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public Node(Item item) {
            this(item, null, null);
        }
    }

    private Node root;
}
