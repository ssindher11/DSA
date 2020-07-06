package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesInBinaryTree {

    static int getCount1(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<SimpleTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                SimpleTree.Node curr = queue.poll();
                count++;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return count;
    }

    static int getCount2(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getCount2(root.left) + getCount2(root.right);
    }

    static int getCount3(SimpleTree.Node root) {
        if (root == null) {
            return 0;
        }
        int lh = 0, rh = 0;
        SimpleTree.Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        } else {
            return 1 + getCount3(root.left) + getCount3(root.right);
        }
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(40);
        tree.left.right = new SimpleTree.Node(50);
        System.out.println("Total nodes = " + getCount1(tree));
        System.out.println("Total nodes = " + getCount2(tree));
        System.out.println("Total nodes = " + getCount3(tree));
    }
}
