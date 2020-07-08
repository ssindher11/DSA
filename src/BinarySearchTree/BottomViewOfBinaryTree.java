package BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    static class Pair {
        BinarySearchTree node;
        int horizontalDist;

        Pair(BinarySearchTree node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    static void printBottomView(BinarySearchTree root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int c = queue.size();
            for (int i = 0; i < c; i++) {
                Pair p = queue.poll();
                BinarySearchTree curr = p.node;
                int hd = p.horizontalDist;
                map.put(hd, curr.data);
                if (curr.left != null) {
                    queue.add(new Pair(curr.left, hd - 1));
                }
                if (curr.right != null) {
                    queue.add(new Pair(curr.right, hd + 1));
                }
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())  {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.left = new BinarySearchTree(20);
        tree.right = new BinarySearchTree(30);
        tree.left.left = new BinarySearchTree(40);
        tree.left.right = new BinarySearchTree(50);
        tree.right.left = new BinarySearchTree(60);
        tree.right.right = new BinarySearchTree(70);
        printBottomView(tree);      // Output: 40 20 60 30 70

        System.out.println();

        BinarySearchTree t = new BinarySearchTree(10);
        t.left = new BinarySearchTree(20);
        t.right = new BinarySearchTree(30);
        t.left.left = new BinarySearchTree(40);
        t.left.right = new BinarySearchTree(50);
        printBottomView(t);      // Output: 40 20 50 30
    }
}
