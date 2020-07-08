package BinarySearchTree;

public class DeleteFromBST {

    static BinarySearchTree getSuccessor(BinarySearchTree root) {
        BinarySearchTree curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static BinarySearchTree delNode(BinarySearchTree root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = delNode(root.left, key);
        } else if (key > root.data) {
            root.right = delNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            BinarySearchTree succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delNode(root.right, succ.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.left = new BinarySearchTree(30);
        tree.left.right = new BinarySearchTree(40);
        tree.right = new BinarySearchTree(70);
        tree.right.left = new BinarySearchTree(60);
        tree.right.right = new BinarySearchTree(80);
        int key = 60;
        BinarySearchTree.printLevelOrder(tree);
        delNode(tree, key);
        BinarySearchTree.printLevelOrder(tree);
    }
}
