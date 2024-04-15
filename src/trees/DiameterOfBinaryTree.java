package trees;

public class DiameterOfBinaryTree {

    private static Integer diameter = 0;

    public static int getDiameter(BinaryTreeNode root) {
        getDiameterUsingMaxDepth(root);
        return diameter;
    }

    private static int getDiameterUsingMaxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = getDiameterUsingMaxDepth(root.left);
        int rightDepth = getDiameterUsingMaxDepth(root.right);
        int diameterTemp = leftDepth + rightDepth;

        if (diameter < diameterTemp) {
            diameter = diameterTemp;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
