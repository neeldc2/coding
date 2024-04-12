package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> traverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<Integer> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            levelOrderTraversal.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return levelOrderTraversal;
    }

    /**
     * This is not optimised solution. Can be made better.
     * This is a solution for Leetcode question: https://leetcode.com/problems/binary-tree-level-order-traversal/
     * Submission is accepted.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        List<List<BinaryTreeNode>> levelOrderTraversalBinaryTreeNode = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        levelOrderTraversal.add(List.of(root.val));
        levelOrderTraversalBinaryTreeNode.add(List.of(root));

        for (int i = 0 ; i < levelOrderTraversalBinaryTreeNode.size() ; i++) {
            List<Integer> list = new ArrayList<>();
            List<BinaryTreeNode> listBinaryTreeNode = new ArrayList<>();

            for(BinaryTreeNode BinaryTreeNode : levelOrderTraversalBinaryTreeNode.get(i)) {
                if (BinaryTreeNode.left != null) {
                    list.add(BinaryTreeNode.left.val);
                    listBinaryTreeNode.add(BinaryTreeNode.left);
                }
                if (BinaryTreeNode.right != null) {
                    list.add(BinaryTreeNode.right.val);
                    listBinaryTreeNode.add(BinaryTreeNode.right);
                }
            }

            if (!list.isEmpty()) {
                levelOrderTraversal.add(list);
                levelOrderTraversalBinaryTreeNode.add(listBinaryTreeNode);
            }
        }

        return levelOrderTraversal;
    }

}
