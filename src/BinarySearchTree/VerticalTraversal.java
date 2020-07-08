package BinarySearchTree;

import java.util.*;

public class VerticalTraversal {

    static class Pair {
        BinarySearchTree node;
        int horizontalDist;

        Pair(BinarySearchTree node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }


    static void printVerticalTraversal(BinarySearchTree root) {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Pair pair = queue.poll();
                BinarySearchTree curr = pair.node;
                int hd = pair.horizontalDist;
                if (map.containsKey(hd)) {
                    map.get(hd).add(curr.data);
                } else {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(curr.data);
                    map.put(hd, arr);
                }
                if (curr.left != null) {
                    queue.add(new Pair(curr.left, hd - 1));
                }
                if (curr.right != null) {
                    queue.add(new Pair(curr.right, hd + 1));
                }
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(1);
        tree.left = new BinarySearchTree(2);
        tree.right = new BinarySearchTree(3);
        tree.left.left = new BinarySearchTree(4);
        tree.left.right = new BinarySearchTree(5);
        tree.right.left = new BinarySearchTree(6);
        tree.right.right = new BinarySearchTree(7);
        tree.right.right.left = new BinarySearchTree(8);
        tree.right.right.left.left = new BinarySearchTree(9);
        printVerticalTraversal(tree);
    }
}
