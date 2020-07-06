package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderTraversal {

    static void printSpiralOrderTraversal1(SimpleTree.Node root) {
        if (root == null) {
            return;
        }
        Queue<SimpleTree.Node> q = new LinkedList<>();
        q.add(root);
        Stack<Integer> s = new Stack<>();
        boolean isStartingFromRight = false;
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                SimpleTree.Node curr = q.poll();
                if (isStartingFromRight) {
                    s.push(curr.key);
                } else {
                    System.out.print(curr.key + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (isStartingFromRight) {
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
            }
            isStartingFromRight = !isStartingFromRight;

            System.out.println();
        }
    }

    static void printSpiralOrderTraversal2(SimpleTree.Node root) {
        Stack<SimpleTree.Node> s1 = new Stack<>();
        Stack<SimpleTree.Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                SimpleTree.Node curr = s1.pop();
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    s2.push(curr.left);
                }
                if (curr.right != null) {
                    s2.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {
                SimpleTree.Node curr = s2.pop();
                System.out.print(curr.key + " ");
                if (curr.right != null) {
                    s1.push(curr.right);
                }
                if (curr.left != null) {
                    s1.push(curr.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(25);
        tree.right.left = new SimpleTree.Node(40);
        tree.right.right = new SimpleTree.Node(50);
        tree.right.left.left = new SimpleTree.Node(70);
        tree.right.left.right = new SimpleTree.Node(80);
        tree.right.right.right = new SimpleTree.Node(90);
        printSpiralOrderTraversal1(tree);
        printSpiralOrderTraversal2(tree);
    }
}
