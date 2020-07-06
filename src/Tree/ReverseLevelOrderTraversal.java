package Tree;

import java.util.*;

public class ReverseLevelOrderTraversal {

    static void reverseNode(SimpleTree.Node root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<SimpleTree.Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int a = q.size();
            for (int i = 0; i < a; i++) {
                SimpleTree.Node curr = q.poll();
                res.add(curr.key);
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
        }
        Collections.reverse(res);
        System.out.println(res);
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(1);
        tree.left = new SimpleTree.Node(2);
        tree.right = new SimpleTree.Node(3);
        tree.left.left = new SimpleTree.Node(4);
        tree.left.right = new SimpleTree.Node(5);
        reverseNode(tree);
    }
}
