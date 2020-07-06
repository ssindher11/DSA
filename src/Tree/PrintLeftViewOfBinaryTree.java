package Tree;

public class PrintLeftViewOfBinaryTree {

    static int maxLevel = 0;
    static void printLeft(SimpleTree.Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        printLeft(root.left, level + 1);
        printLeft(root.right, level + 1);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.right.left = new SimpleTree.Node(40);
        tree.right.right = new SimpleTree.Node(50);
        printLeft(tree, 1);
    }
}
