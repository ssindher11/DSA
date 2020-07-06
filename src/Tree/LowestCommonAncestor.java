package Tree;

import java.util.ArrayList;

public class LowestCommonAncestor {

    static boolean findPath(SimpleTree.Node root, ArrayList<SimpleTree.Node> p, int n) {
        if (root == null) {
            return false;
        }
        p.add(root);
        if (root.key == n) {
            return true;
        }
        if (findPath(root.left, p, n) || findPath(root.right, p, n)) {
            return true;
        }
        p.remove(p.size() - 1);
        return false;
    }

    static SimpleTree.Node lca(SimpleTree.Node root, int n1, int n2) {
        ArrayList<SimpleTree.Node> l1 = new ArrayList<>();
        ArrayList<SimpleTree.Node> l2 = new ArrayList<>();
        if (!findPath(root, l1, n1) || !findPath(root, l2, n2)) {
            return null;
        }
        for (int i = 0; i < l1.size() - 1 && i < l2.size() - 1; i++) {
            if (l1.get(i + 1) != l2.get(i + 1)) {
                return l1.get(i);
            }
        }
        return null;
    }

    static SimpleTree.Node lcaEfficient(SimpleTree.Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.key == n1 || root.key == n2) {
            return root;
        }
        SimpleTree.Node lca1 = lcaEfficient(root.left, n1, n2);
        SimpleTree.Node lca2 = lcaEfficient(root.left, n1, n2);
        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.right.left = new SimpleTree.Node(40);
//        tree.right.left.left = new SimpleTree.Node(60);
        tree.right.right = new SimpleTree.Node(50);
//        tree.right.right.left = new SimpleTree.Node(70);
//        tree.right.right.right = new SimpleTree.Node(80);
//        SimpleTree.Node.printLevelOrderLine1(tree);
        System.out.println("LCA: " + lcaEfficient(tree, 20, 40).key);
    }
}
