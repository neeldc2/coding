package binarysearchtree;

public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTreeNode root = new BinarySearchTreeNode(8);
        root.left = new BinarySearchTreeNode(5);
        root.right = new BinarySearchTreeNode(12);
        root.left.left = new BinarySearchTreeNode(4);
        root.left.right = new BinarySearchTreeNode(7);
        root.left.right.left = new BinarySearchTreeNode(6);
        root.right.left = new BinarySearchTreeNode(10);
        root.right.right = new BinarySearchTreeNode(14);
        root.right.right.left = new BinarySearchTreeNode(13);

        System.out.println("Binary Search Tree");
        {
            System.out.print("Search Found: ");
            BinarySearchTreeNode nodeFound = Search.searchBST(root, 10);
            System.out.println(nodeFound == null ? "True" : "False");
        }

    }

}
