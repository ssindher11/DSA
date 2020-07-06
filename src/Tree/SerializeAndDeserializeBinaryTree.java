package Tree;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {

    static final int EMPTY = -1;

    static void serialize(SimpleTree.Node root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.key);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    static int index = 0;
    static SimpleTree.Node deserialize(ArrayList<Integer> arr) {
        if (index == arr.size()) {
            return null;
        }
        int val = arr.get(index);
        index++;
        if (val == EMPTY) {
            return null;
        }
        SimpleTree.Node root = new SimpleTree.Node(val);
        root.left = deserialize(arr);
        root.right = deserialize(arr);
        return root;
    }

    public static void main(String[] args) {
        SimpleTree.Node tree = new SimpleTree.Node(10);
        tree.left = new SimpleTree.Node(20);
        tree.right = new SimpleTree.Node(30);
        tree.left.left = new SimpleTree.Node(40);
        tree.left.right = new SimpleTree.Node(50);
        tree.right.right = new SimpleTree.Node(60);
        ArrayList<Integer> serializedTree = new ArrayList<>();
        serialize(tree, serializedTree);
        System.out.println(serializedTree);
        SimpleTree.Node root = deserialize(serializedTree);
        SimpleTree.Node.printLevelOrderLine1(root);
    }
}
