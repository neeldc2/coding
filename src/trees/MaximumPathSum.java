package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumPathSum {

    static AtomicInteger maxPathSum = new AtomicInteger();

    public static int maxPathSum(BinaryTreeNode root) {
        maxPathSum.set(root.val);
        optimisedCalculate(root);
        return maxPathSum.get();
    }

    /**
     * This is the solution I came up with. But it can be optimised as below method optimisedCalculate(BinaryTreeNode root)
     *
     * @param root
     * @return
     */
    public static int calculate(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (maxPathSum.get() < root.val) {
                maxPathSum.set(root.val);
            }
            return root.val;
        }

        int leftSubTreeSum = calculate(root.left);
        int rightSubTreeSum = calculate(root.right);

        if (leftSubTreeSum + rightSubTreeSum + root.val > maxPathSum.get()) {
            maxPathSum.set(leftSubTreeSum + rightSubTreeSum + root.val);
        }
        if (leftSubTreeSum + root.val > maxPathSum.get()) {
            maxPathSum.set(leftSubTreeSum + root.val);
        }
        if (rightSubTreeSum + root.val > maxPathSum.get()) {
            maxPathSum.set(rightSubTreeSum + root.val);
        }
        if (root.val > maxPathSum.get()) {
            maxPathSum.set(root.val);
        }

        return Math.max(Math.max(leftSubTreeSum, rightSubTreeSum) + root.val, root.val);
    }

    public static int optimisedCalculate(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeSum = optimisedCalculate(root.left);
        int rightSubTreeSum = optimisedCalculate(root.right);

        // if left sub tree sum is negative, do not include it in the sum calculation of current node
        // similarly for right sub tree sum
        leftSubTreeSum = Math.max(0, leftSubTreeSum);
        rightSubTreeSum = Math.max(0, rightSubTreeSum);

        if (leftSubTreeSum + rightSubTreeSum + root.val > maxPathSum.get()) {
            maxPathSum.set(leftSubTreeSum + rightSubTreeSum + root.val);
        }

        return Math.max(leftSubTreeSum, rightSubTreeSum) + root.val;
    }


}
