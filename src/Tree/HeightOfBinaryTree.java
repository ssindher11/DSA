package Tree;

public class HeightOfBinaryTree {

    static int getHeight(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        /*SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(30);
        tree.right = new SimpleTree.Node(40);
        tree.left.left = new SimpleTree.Node(80);
        tree.left.left.right = new SimpleTree.Node(70);
        tree.right.left = new SimpleTree.Node(60);
        tree.right.right = new SimpleTree.Node(20);*/

        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(40);
        tree.right = new SimpleTree.Node(60);
        tree.left.left = new SimpleTree.Node(70);
        tree.left.left.left = new SimpleTree.Node(80);

        System.out.println("Height of tree: " + getHeight(tree));
    }
}
