package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    static void mirror(SimpleTree.Node node) {
        if (node == null) {
            return;
        }
        Queue<SimpleTree.Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            SimpleTree.Node curr = q.poll();
            SimpleTree.Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(1);
        tree.left = new SimpleTree.Node(3);
        tree.right = new SimpleTree.Node(2);
        tree.right.left = new SimpleTree.Node(5);
        tree.right.right = new SimpleTree.Node(4);
        SimpleTree.Node.printLevelOrderLine1(tree);     // Original tree
        mirror(tree);
        SimpleTree.Node.printLevelOrderLine1(tree);     // Mirror output
    }
}
