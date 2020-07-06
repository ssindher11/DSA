package Tree;

public class BurnTreeFromLeaf {

    static class Distance {
        int val;

        Distance(int d) {
            this.val = d;
        }
    }

    static int res = 0;

    static int burnTime(SimpleTree.Node root, int leaf, Distance d) {
        if (root == null) {
            return 0;
        }
        if (root.key == leaf) {
            d.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);
        if (ldist.val != -1) {
            d.val = ldist.val + 1;
            res = Math.max(res, rh + d.val);
        } else if (rdist.val != -1) {
            d.val = rdist.val + 1;
            res = Math.max(res, lh + d.val);
        }
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(40);
        tree.left.right = new SimpleTree.Node(50);
        tree.left.left.left = new SimpleTree.Node(60);
        tree.left.left.left.left = new SimpleTree.Node(70);
        int leaf = 50;
        System.out.println("Time to burn: " + burnTime(tree, leaf, new Distance(-1)));
    }
}
