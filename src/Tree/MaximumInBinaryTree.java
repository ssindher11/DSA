package Tree;

public class MaximumInBinaryTree {

    static int getMax(SimpleTree.Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(getMax(root.left), getMax(root.right)), root.key);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(30);
        tree.right = new SimpleTree.Node(40);
        tree.left.left = new SimpleTree.Node(80);
        tree.left.left.right = new SimpleTree.Node(70);
        tree.right.left = new SimpleTree.Node(60);
        tree.right.right = new SimpleTree.Node(20);
        System.out.println("Max value in tree = " + getMax(tree));
    }
}
