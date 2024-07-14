package trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static List<Integer> traverse(BinaryTreeNode root) {
        List<Integer> morrisInorderTraversal = new ArrayList<>();

        if (root == null) {
            return morrisInorderTraversal;
        }

        BinaryTreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // find inorder predecessor
                BinaryTreeNode inOrderPredecessor = findInorderPredecessor(node);
                // link current node and inorder predecessor
                if (inOrderPredecessor.right != node) {
                    inOrderPredecessor.right = node;
                    node = node.left;
                } else {
                    inOrderPredecessor.right = null;
                    morrisInorderTraversal.add(node.val);
                    node = node.right;
                }
            } else {
                morrisInorderTraversal.add(node.val);
                node=node.right;
            }
        }

        return morrisInorderTraversal;
    }

    private static BinaryTreeNode findInorderPredecessor(BinaryTreeNode node) {
        BinaryTreeNode temp = node;
        temp = temp.left;
        while (true) {
            if (temp.right == null || temp.right == node) {
                break;
            }
            temp = temp.right;
        }
        return temp;
    }
}
