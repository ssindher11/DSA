package BinarySearchTree;

public class InsertInBST {

    static BinarySearchTree insertRecursively(BinarySearchTree root, int key) {
        if (root == null) {
            return new BinarySearchTree(key);
        }
        if (root.data < key) {
            root.right = insertRecursively(root.right, key);
        } else {
            root.left = insertRecursively(root.left, key);
        }
        return root;
    }

    static BinarySearchTree insert(BinarySearchTree root, int key) {
        BinarySearchTree newNode = new BinarySearchTree(key);
        BinarySearchTree parent = null, curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.data < key) {
                curr = curr.right;
            } else if (curr.data > key) {
                curr = curr.left;
            } else {
                return root;
            }
        }
        if (parent == null) {
            return newNode;
        }
        if (parent.data > key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.left = new BinarySearchTree(5);
        tree.right = new BinarySearchTree(15);
        tree.right.left = new BinarySearchTree(12);
        tree.right.right = new BinarySearchTree(18);
        int key = 20;
        BinarySearchTree.printLevelOrder(tree);
        BinarySearchTree updated = insert(tree, key);
//        BinarySearchTree updated = insertRecursively(tree, key);
        BinarySearchTree.printLevelOrder(updated);
    }
}
