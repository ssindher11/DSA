package BinarySearchTree;

public class SearchInBST {

    static boolean search1(BinarySearchTree root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return search1(root.left, key);
        } else {
            return search1(root.right, key);
        }
    }

    static boolean search2(BinarySearchTree root, int key) {
        while (root != null) {
            if (root.data == key) {
                return true;
            }
            if (root.data < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(15);
        tree.left = new BinarySearchTree(5);
        tree.left.left = new BinarySearchTree(3);
        tree.right = new BinarySearchTree(20);
        tree.right.left = new BinarySearchTree(18);
        tree.right.right = new BinarySearchTree(80);
        tree.right.left.left = new BinarySearchTree(16);
        int key = 16;
        System.out.println(search1(tree, key));
        System.out.println(search2(tree, key));
    }
}
