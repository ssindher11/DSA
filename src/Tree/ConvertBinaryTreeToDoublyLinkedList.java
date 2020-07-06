package Tree;

public class ConvertBinaryTreeToDoublyLinkedList {

    static SimpleTree.Node prev ;
    static SimpleTree.Node convert(SimpleTree.Node root) {
        if (root == null) {
            return null;
        }
        SimpleTree.Node head = convert(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
        return head;
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(5);
        tree.right = new SimpleTree.Node(20);
        tree.right.left = new SimpleTree.Node(25);
        tree.right.right = new SimpleTree.Node(30);
        convert(tree);
    }
}
