package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    int data;
    BinarySearchTree left, right;

    BinarySearchTree(int data) {
        this.data = data;
    }

    static void printLevelOrder(BinarySearchTree root) {
        System.out.println("\nLevel Order Traversal");
        if (root == null) {
            return;
        }
        Queue<BinarySearchTree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int a = q.size();
            for (int i = 0; i < a; i++) {
                BinarySearchTree curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    static void printInorderTraversal(BinarySearchTree root) {
        if (root == null) {
            return;
        }
        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }
}
