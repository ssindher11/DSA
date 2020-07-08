package BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    static class Pair {
        BinarySearchTree node;
        int horizontalDist;

        Pair(BinarySearchTree node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    static void printTopView(BinarySearchTree root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Pair p = queue.poll();
                BinarySearchTree curr = p.node;
                int hd = p.horizontalDist;
                if (!map.containsKey(hd)) {
                    map.put(hd, curr.data);
                }
                if (curr.left != null) {
                    queue.add(new Pair(curr.left, hd - 1));
                }
                if (curr.right != null) {
                    queue.add(new Pair(curr.right, hd + 1));
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())  {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.left = new BinarySearchTree(20);
        tree.right = new BinarySearchTree(50);
        tree.left.left = new BinarySearchTree(30);
        tree.left.right = new BinarySearchTree(40);
        tree.right.left = new BinarySearchTree(60);
        tree.right.right = new BinarySearchTree(70);
        printTopView(tree);
    }
}
