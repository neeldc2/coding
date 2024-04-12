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
                node = binaryTreeAndItsPosition.node;
                NodePosition nodePosition = binaryTreeAndItsPosition.nodePosition;

                if (nodePosition == NodePosition.MIDDLE) {
                    postorderTraversal.add(node.val);
                    node = null;
                }
            }
        }

        return postorderTraversal;
    }

}

class BinaryTreeAndItsPosition {
    BinaryTreeNode node;
    NodePosition nodePosition;

    public BinaryTreeAndItsPosition(BinaryTreeNode node, NodePosition nodePosition) {
        this.node = node;
        this.nodePosition = nodePosition;
    }
}
