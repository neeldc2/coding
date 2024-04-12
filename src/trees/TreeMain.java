package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeMain {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        List<Integer> levelOrderTraversal = LevelOrderTraversal.traverse(root);
        printTraversal(levelOrderTraversal);

        List<Integer> inorderTraversal = InorderTraversal.recursiveTraversal(root, new ArrayList<>());
        printTraversal(inorderTraversal);

        inorderTraversal = InorderTraversal.iterativeTraversal(root);
        printTraversal(inorderTraversal);
    }

    private static void printTraversal(List<Integer> traversal) {
        System.out.println(
                traversal.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }

}
