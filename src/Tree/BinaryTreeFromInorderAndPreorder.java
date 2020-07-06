package Tree;

public class BinaryTreeFromInorderAndPreorder {

    static int preIndex = 0;
    static SimpleTree.Node constructTree(int[] in, int[] pre, int is, int ie) {
        if (is > ie) {
            return null;
        }
        SimpleTree.Node root = new SimpleTree.Node(pre[preIndex++]);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = constructTree(in, pre, is, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, ie);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {20, 10, 40, 30, 50};
        int[] pre = {10, 20, 30, 40, 50};
        SimpleTree.Node.printLevelOrderLine1(constructTree(in, pre, 0, in.length - 1));
    }
}
