package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfBinaryTreeAtomicInteger {

    public static int getDiameter(BinaryTreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        getDiameterUsingMaxDepth(root, diameter);
        return diameter.get();
    }

    private static int getDiameterUsingMaxDepth(BinaryTreeNode root, AtomicInteger diameter) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = getDiameterUsingMaxDepth(root.left, diameter);
        int rightDepth = getDiameterUsingMaxDepth(root.right, diameter);
        int diameterTemp = leftDepth + rightDepth;

        if (diameter.get() < diameterTemp) {
            diameter.set(diameterTemp);
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
