package binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        // Important Question: Try Recursive
        {
            System.out.println("Create Binary Search Tree from PreOrder");
            List<Integer> preOrderList = List.of(50, 25, 15, 40, 75, 60, 90);
            BinarySearchTreeNode bst = BSTFromPreOrder.createBinarySearchTree(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));

            preOrderList = List.of(50, 25, 15, 40, 30, 45, 75, 60, 90);
            bst = BSTFromPreOrder.createBinarySearchTree(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));

            preOrderList = List.of(50, 25, 15, 40, 30, 75, 60, 90);
            bst = BSTFromPreOrder.createBinarySearchTree(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));
        }

        {
            System.out.println("Create Binary Search Tree from PreOrder");
            List<Integer> preOrderList = List.of(50, 25, 15, 40, 75, 60, 90);
            BinarySearchTreeNode bst = BSTFromPreOrder.createBinarySearchTreeRecursively(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));

            preOrderList = List.of(50, 25, 15, 40, 30, 45, 75, 60, 90);
            bst = BSTFromPreOrder.createBinarySearchTreeRecursively(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));

            preOrderList = List.of(50, 25, 15, 40, 30, 75, 60, 90);
            bst = BSTFromPreOrder.createBinarySearchTreeRecursively(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));

            preOrderList = List.of(1, 3);
            bst = BSTFromPreOrder.createBinarySearchTreeRecursively(preOrderList);
            printTraversal(recursiveTraversal(bst, new ArrayList<>()));
        }

    }

    public static List<Integer> recursiveTraversal(BinarySearchTreeNode root, List<Integer> preorderTraversal) {
        if (root == null) {
            return preorderTraversal;
        }

        preorderTraversal.add(root.val);
        recursiveTraversal(root.left, preorderTraversal);
        recursiveTraversal(root.right, preorderTraversal);

        return preorderTraversal;
    }

    public static void printTraversal(List<Integer> traversal) {
        System.out.println(
                traversal.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }

}
