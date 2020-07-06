package Tree;

public class SizeOfBinaryTree {

    static int getSize(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(40);
        tree.left.right = new SimpleTree.Node(50);
        tree.right.right = new SimpleTree.Node(60);
        System.out.println("Size = " + getSize(tree));
    }
}
