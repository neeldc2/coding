package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public static List<Integer> recursiveTraversal(BinaryTreeNode root, List<Integer> preorderTraversal) {
        if (root == null) {
            return preorderTraversal;
        }

        recursiveTraversal(root.left, preorderTraversal);
        recursiveTraversal(root.right, preorderTraversal);
        preorderTraversal.add(root.val);

        return preorderTraversal;
    }

    /**
     * This is my own solution.
     * I have submitted solution in Leetcode where NodePosition is a String, not Enum.
     * BinaryTreeAndItsPosition is a Record.
     * @param root
     * @return
     */
    public static List<Integer> iterativeTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeAndItsPosition> stack = new Stack<>();
        List<Integer> postorderTraversal = new ArrayList<>();

        if (root == null) {
            return postorderTraversal;
        }

        BinaryTreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(new BinaryTreeAndItsPosition(node, NodePosition.MIDDLE));
                if (node.right != null) {
                    stack.push(new BinaryTreeAndItsPosition(node.right, NodePosition.RIGHT));
                }
                node = node.left;
            } else {
                BinaryTreeAndItsPosition binaryTreeAndItsPosition = stack.pop();
                node = binaryTreeAndItsPosition.node();
                NodePosition nodePosition = binaryTreeAndItsPosition.nodePosition();

                if (nodePosition == NodePosition.MIDDLE) {
                    postorderTraversal.add(node.val);
                    node = null;
                }
            }
        }

        return postorderTraversal;
    }

    /**
     * Using 2 stacks.
     * In stack1, insert the root.
     * Until stack 1 is empty, pop node from stack 1.
     * Insert left and right of popped node in stack 1.
     * Push popped node to stack 2.
     * @param root
     * @return
     */
    public static List<Integer> iterativeTraversalWithTwoStacks(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> postorderTraversal = new ArrayList<>();

        if (root == null) {
            return postorderTraversal;
        }

        stack1.push(root);

        while (!stack1.isEmpty()) {
            BinaryTreeNode node = stack1.pop();
            stack2.push(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            postorderTraversal.add(stack2.pop());
        }

        return postorderTraversal;
    }

}

record BinaryTreeAndItsPosition(BinaryTreeNode node, NodePosition nodePosition) {}
