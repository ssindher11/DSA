package Tree;

public class ChildrenSumProperty {

    static boolean isCSP(SimpleTree.Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }
        return (root.key == sum && isCSP(root.left) && isCSP(root.right));
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(20);
        tree.left = new SimpleTree.Node(8);
        tree.right = new SimpleTree.Node(12);
        tree.left.left = new SimpleTree.Node(3);
        tree.left.right = new SimpleTree.Node(5);
        System.out.println("Follows CSP : " + isCSP(tree));
    }
}
