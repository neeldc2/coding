package binarysearchtree;

public class Search {
    public static BinarySearchTreeNode searchBST(BinarySearchTreeNode root, int val) {
        BinarySearchTreeNode node = root;
        while (node != null) {
            if (val < node.val) {
                node = node.left;
            } else if (val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }
}
