package Tree;

public class PrintNodesAtDistanceK {

    static void printNode(SimpleTree.Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + " ");
        } else {
            printNode(root.left, k - 1);
            printNode(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(40);
        tree.left.right = new SimpleTree.Node(50);
        tree.right.right = new SimpleTree.Node(70);
        tree.right.right.right = new SimpleTree.Node(80);
        int k = 2;
        printNode(tree, k);
    }
}
