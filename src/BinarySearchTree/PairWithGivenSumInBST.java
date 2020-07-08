package BinarySearchTree;

import java.util.HashSet;

public class PairWithGivenSumInBST {

    static boolean isPairSum(BinarySearchTree root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (isPairSum(root.left, sum, set)) {
            return true;
        }
        if (set.contains(sum - root.data)) {
            return true;
        }
        set.add(root.data);
        return isPairSum(root.right, sum, set);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(18);
        tree.left = new BinarySearchTree(8);
        tree.left.left = new BinarySearchTree(4);
        tree.right = new BinarySearchTree(60);
        tree.right.left = new BinarySearchTree(20);
        tree.right.right = new BinarySearchTree(80);
        int sum = 22;
        System.out.println(isPairSum(tree, sum, new HashSet<>()));
    }
}
