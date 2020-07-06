package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    static int getMaxWidth(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        int count = 0;
        Queue<SimpleTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                SimpleTree.Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                    count += 1;
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    count += 1;
                }
            }
            res = Math.max(res, count);
            count = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(8);
        tree.left = new SimpleTree.Node(12);
        tree.right = new SimpleTree.Node(15);
        tree.left.left = new SimpleTree.Node(13);
        tree.left.right = new SimpleTree.Node(14);
        tree.right.right = new SimpleTree.Node(16);
        tree.left.left.left = new SimpleTree.Node(17);
        tree.left.left.right = new SimpleTree.Node(17);
        tree.right.right.left = new SimpleTree.Node(17);
        tree.right.right.right = new SimpleTree.Node(17);
        System.out.println("Max Width = " + getMaxWidth(tree));
    }
}
