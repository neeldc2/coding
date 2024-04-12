package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public static List<Integer> recursiveTraversal(BinaryTreeNode root, List<Integer> preorderTraversal) {
        if (root == null) {
            return preorderTraversal;
        }

        preorderTraversal.add(root.val);
        recursiveTraversal(root.left, preorderTraversal);
        recursiveTraversal(root.right, preorderTraversal);

        return preorderTraversal;
    }

    public static List<Integer> iterativeTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> preorderTraversal = new ArrayList<>();

        if (root == null) {
            return preorderTraversal;
        }

        BinaryTreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                preorderTraversal.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }

        return preorderTraversal;
    }

}
