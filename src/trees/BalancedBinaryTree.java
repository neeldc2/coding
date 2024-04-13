package trees;

public class BalancedBinaryTree {

    public static boolean isBinaryTreeBalanced(BinaryTreeNode root) {
        if (root == null) {
            return false;
        }

        int i = verify(root);

        if (i < 0) {
            return false;
        }
        return true;
    }

    public static int verify(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = verify(root.left);
        int rightDepth = verify(root.right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }

}
