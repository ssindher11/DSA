package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleTree {

    static class Node {
        Node left;
        int key;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public void printInorder(Node node) {
            if (node != null) {
                printInorder(node.left);
                System.out.print(node.key + " ");
                printInorder(node.right);
            }
        }

        public void printPreOrder(Node node) {
            if (node != null) {
                System.out.print(node.key + " ");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }

        public void printPostOrder(Node node) {
            if (node != null) {
                printPostOrder(node.left);
                printPostOrder(node.right);
                System.out.print(node.key + " ");
            }
        }

        public void printLevelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node currNode = queue.poll();
                System.out.print(currNode.key + " ");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        public static void printLevelOrderLine1(Node root) {
            System.out.println("Level Order Traversal Line by Line");
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (queue.size() > 1) {
                Node curr = queue.poll();
                if (curr == null) {
                    System.out.println();
                    queue.add(null);
                    continue;
                }
                System.out.print(curr.key + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        public void printLevelOrderLine2(Node root) {
            System.out.println("Level Order Traversal Line by Line");
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    Node curr = queue.poll();
                    System.out.print(curr.key + " ");
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.left.right.left = new Node(70);
        node.left.right.right = new Node(80);
        node.right.right = new Node(60);

        System.out.println("Inorder Traversal");
        node.printInorder(node);
        System.out.println("\nPreOrder Traversal");
        node.printPreOrder(node);
        System.out.println("\nPostOrder Traversal");
        node.printPostOrder(node);
        System.out.println("\nLevel Order Traversal");
        node.printLevelOrder(node);
        System.out.println();
        node.printLevelOrderLine1(node);
        System.out.println();
        node.printLevelOrderLine2(node);
    }
}
