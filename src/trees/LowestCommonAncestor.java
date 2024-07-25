package trees;

public class LowestCommonAncestor {

    private static BinaryTreeNode lca;
    private static Integer value1;
    private static Integer value2;

    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        lca = null;
        value1 = p.val;
        value2 = q.val;
        getLCA(root);
        return lca;
    }

    private static boolean getLCA(BinaryTreeNode node) {
        if (node == null) {
            return false;
        }

        if (lca != null) {
            return true;
        }

        boolean isValuePresentOnLeft = getLCA(node.left);
        boolean isValuePresentOnRight = getLCA(node.right);

        if (lca != null) {
            return true;
        }

        if (isValuePresentOnLeft && isValuePresentOnRight) {
            lca = node;
            return true;
        }

        if (node.val == value1 || node.val == value2) {
            if (isValuePresentOnLeft || isValuePresentOnRight) {
                lca = node;
            }
            return true;
        }

        if (isValuePresentOnLeft || isValuePresentOnRight) {
            return true;
        }

        return false;
    }

}
