package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

    public static int maxDepthUsingLevelOrderTraversal(BinaryTreeNode root) {
        List<Queue<BinaryTreeNode>> queueList = new ArrayList<>();

        if (root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queueList.add(queue);

        for (int i = 0 ; i < queueList.size() ; i++) {
            queue = queueList.get(i);

            Queue newQueue = new LinkedList();
            while (!queue.isEmpty()) {
                BinaryTreeNode node = queue.poll();
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }

            if (!newQueue.isEmpty()) {
                queueList.add(newQueue);
            }
        }

        return queueList.size();
    }

    public static int maxDepthUsingRecursion(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(maxDepthUsingRecursion(root.left), maxDepthUsingRecursion(root.right));
    }

}
