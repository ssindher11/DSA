package BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumInBST {

    static void recSum(BinarySearchTree root, int hd, TreeMap<Integer, Integer> mp) {
        if (root == null) {
            return;
        }
        recSum(root.left, hd - 1, mp);
        int pSum = (mp.get(hd) == null) ? 0 : mp.get(hd);
        mp.put(hd, pSum + root.data);
        recSum(root.right, hd + 1, mp);
    }

    static void vSum(BinarySearchTree root) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        recSum(root, 0, mp);
        for (Map.Entry<Integer, Integer> sum : mp.entrySet()) {
            System.out.print(mp.get(sum.getKey()) + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.left = new BinarySearchTree(20);
        tree.right = new BinarySearchTree(50);
        tree.left.left = new BinarySearchTree(30);
        tree.left.right = new BinarySearchTree(40);
        vSum(tree);
    }
}
