package trees;

public class IsBinaryTreeSymmetric {

    public static boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) {
            return false;
        }

        return checkSymmetry(root.left, root.right);
    }

    public static boolean checkSymmetry(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        boolean isSymmetry = checkSymmetry(node1.right, node2.left);
        boolean isSymmetry2 = checkSymmetry(node1.left, node2.right);

        return isSymmetry && isSymmetry2;
    }

}
