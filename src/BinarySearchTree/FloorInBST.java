package BinarySearchTree;

public class FloorInBST {

    static BinarySearchTree findFloor(BinarySearchTree root, int key) {
        BinarySearchTree res = null;
        while (root != null) {
            if (root.data == key) {
                return root;
            }
            if (key < root.data) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.left = new BinarySearchTree(30);
        tree.left.left = new BinarySearchTree(20);
        tree.left.right = new BinarySearchTree(40);
        tree.right = new BinarySearchTree(70);
        tree.right.left = new BinarySearchTree(60);
        tree.right.right = new BinarySearchTree(80);
        tree.right.left.left = new BinarySearchTree(55);
        tree.right.left.right = new BinarySearchTree(65);
        int key = 58;
        System.out.println("Floor: " + findFloor(tree, key).data);
    }
}
