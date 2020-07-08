package BinarySearchTree;

import java.util.ArrayList;

public class CheckForBST {

    static ArrayList<Integer> arr = new ArrayList<>();

    static void doInorderTraversal(BinarySearchTree root) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left);
        arr.add(root.data);
        doInorderTraversal(root.right);
    }

    static boolean isBST(BinarySearchTree root) {
        if (root == null) {
            return true;
        }
        doInorderTraversal(root);
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Efficient Solution 1
    static boolean isBST2(BinarySearchTree root, int l, int r) {
        if (root == null) {
            return true;
        }
        return (root.data > l && root.data < r && isBST2(root.left, l, root.data) && isBST2(root.right, root.data, r));
    }

    static int prev = Integer.MIN_VALUE;
    static boolean isBST3(BinarySearchTree root) {
        if (root == null) {
            return true;
        }
        if (!isBST3(root.left)) {
            return false;
        }
        if (root.data <= prev) {
            return false;
        }
        prev = root.data;
        return isBST3(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(20);
        tree.left = new BinarySearchTree(8);
        tree.right = new BinarySearchTree(30);
        tree.right.left = new BinarySearchTree(18);
        tree.right.right = new BinarySearchTree(35);
        System.out.println(isBST(tree));
        System.out.println(isBST2(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST3(tree));
    }
}
