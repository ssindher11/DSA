package BinarySearchTree;

public class FixBSTwithTwoNodesSwapped {

    /*static Integer prev = Integer.MIN_VALUE, i1 = null, i2 = null;

    static void getProblemElements(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] < prev) {
                if (i1 == null) {
                    i1 = prev;
                }
                i2 = arr[i];
            }
            prev = arr[i];
        }
        System.out.println(i1 + "\t" + i2);
        prev = Integer.MIN_VALUE;
        i1 = null;
        i2 = null;
    }
*/
    static BinarySearchTree prev = null, first = null, second = null;
    static void fixBST(BinarySearchTree root) {
        if (root == null) {
            return;
        }
        fixBST(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        fixBST(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(18);
        tree.left = new BinarySearchTree(60);
        tree.left.left = new BinarySearchTree(4);
        tree.right = new BinarySearchTree(20);
        tree.right.left = new BinarySearchTree(8);
        tree.right.right = new BinarySearchTree(80);
        fixBST(tree);
        System.out.println(first.data + "\t" + second.data);
    }
}
