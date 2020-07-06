package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTreeTraversal {

    static ArrayList<Integer> zigZagTraversal(SimpleTree.Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean isRev = false;
        Queue<SimpleTree.Node> q = new LinkedList<>();
        Stack<SimpleTree.Node> s = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            int c = q.size();
            for (int i = 0; i < c; i++) {
                SimpleTree.Node curr = q.poll();
                if (isRev) {
                    s.push(curr);
                } else {
                    res.add(curr.key);
                }
                if (curr.left != null) {
                   q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (isRev) {
                while (!s.isEmpty()) {
                    res.add(s.pop().key);
                }
            }
            isRev = !isRev;
        }
        return res;
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(1);
        tree.left = new SimpleTree.Node(2);
        tree.right = new SimpleTree.Node(3);
        tree.left.left = new SimpleTree.Node(7);
        tree.left.right = new SimpleTree.Node(6);
        tree.right.left = new SimpleTree.Node(5);
        tree.right.right = new SimpleTree.Node(4);
        System.out.println(zigZagTraversal(tree));
    }
}
