package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static List<Integer> recursiveTraversal(BinaryTreeNode root, List<Integer> inorderTraversal) {
        if (root == null) {
            return inorderTraversal;
        }

        recursiveTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        recursiveTraversal(root.right, inorderTraversal);

        return inorderTraversal;
    }

    public static List<Integer> iterativeTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> inorderTraversal = new ArrayList<>();

        if (root == null) {
            return inorderTraversal;
        }

        BinaryTreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                inorderTraversal.add(node.val);
                node = node.right;
            }
        }

        return inorderTraversal;
    }

}
