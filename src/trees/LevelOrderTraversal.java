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

}
