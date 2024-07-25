package binarysearchtree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BSTFromPreOrder {

    public static BinarySearchTreeNode createBinarySearchTree(List<Integer> preOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        BinarySearchTreeNode root = new BinarySearchTreeNode(preOrder.get(0));
        BinarySearchTreeNode node = root;
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        Map<BinarySearchTreeNode, Integer> maxValueForNode = new HashMap<>();
        maxValueForNode.put(root, Integer.MAX_VALUE);

        int i = 1;
        while (i < preOrder.size()) {
            Integer preOrderElement = preOrder.get(i);

            if (preOrderElement < node.val) {
                node.left = new BinarySearchTreeNode(preOrderElement);
                maxValueForNode.put(node.left, node.val);
                stack.push(node);
                node = node.left;
            } else {
                while (maxValueForNode.get(node) < preOrderElement) {
                    node = stack.pop();
                }
                node.right = new BinarySearchTreeNode(preOrderElement);
                maxValueForNode.put(node.right, maxValueForNode.get(node));
                node = node.right;
            }

            i++;
        }

        return root;
    }

    private static Integer index = 0;

    public static BinarySearchTreeNode createBinarySearchTreeRecursively(List<Integer> preOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        index = 0;

        return createBST(preOrder, Integer.MAX_VALUE);
    }

    private static BinarySearchTreeNode createBST(List<Integer> preOrder, Integer maxValue) {
        if (preOrder.isEmpty() || index >= preOrder.size()) {
            return null;
        }

        Integer nodeValue = preOrder.get(index);
        BinarySearchTreeNode node = null;

        if (nodeValue <= maxValue) {
            node = new BinarySearchTreeNode(nodeValue);
            index = index + 1;
        } else {
            return null;
        }

        node.left = createBST(preOrder, nodeValue);
        node.right = createBST(preOrder, maxValue);

        return node;
    }

}
