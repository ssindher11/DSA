package Tree;

public class DiameterOfBinaryTree {


    static int res = 0;
    static int getDiameter(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        int lh = getDiameter(root.left);
        int rh = getDiameter(root.right);
        res = Math.max(res, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(60);
        tree.left.left = new SimpleTree.Node(30);
        tree.left.right = new SimpleTree.Node(80);
        tree.left.left.left = new SimpleTree.Node(40);
        tree.left.left.right = new SimpleTree.Node(50);
        tree.left.left.left.left = new SimpleTree.Node(60);
        tree.left.right.right = new SimpleTree.Node(90);
        tree.left.right.right.right = new SimpleTree.Node(18);
        System.out.println("Diameter: " + getDiameter(tree));

        SimpleTree.Node root = new SimpleTree.Node(1);
        root.left = new SimpleTree.Node(2);
        root.right = new SimpleTree.Node(3);
        root.left.left = new SimpleTree.Node(4);
        root.left.right = new SimpleTree.Node(5);
        System.out.println("Diameter: " + getDiameter(root));
    }
}
