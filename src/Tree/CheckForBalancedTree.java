package Tree;

public class CheckForBalancedTree {

    static int isBalanced(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced(root.left);
        if (lh == -1) return -1;
        int rh = isBalanced(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        else return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(8);
        tree.left = new SimpleTree.Node(12);
        tree.right = new SimpleTree.Node(15);
        tree.left.left = new SimpleTree.Node(13);
        tree.left.right = new SimpleTree.Node(14);
        tree.right.right = new SimpleTree.Node(16);
        tree.right.right.right = new SimpleTree.Node(17);
        if (isBalanced(tree) != -1) {
            System.out.println("isBalanced: True");
        } else {
            System.out.println("isBalanced: False");
        }
    }
}
