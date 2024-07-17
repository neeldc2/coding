package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInOrderAndPreOrder {
    public static BinaryTreeNode constructTree(final List<Integer> inorderTraversal,
                                               final List<Integer> preorderTraversal) {
        BinaryTreeNode root = new BinaryTreeNode(preorderTraversal.getFirst());

        List<Integer> inorderLeftList = getInorderLeftList(inorderTraversal, root.val);
        if (inorderLeftList.isEmpty()) {
            root.left = null;
        } else {
            List<Integer> preorderLeftList = getPreOrderSubset(inorderLeftList, preorderTraversal);
            root.left = constructTree(inorderLeftList, preorderLeftList);
        }

        List<Integer> inorderRightList = getInorderRightList(inorderTraversal, root.val);
        if (inorderLeftList.isEmpty()) {
            root.left = null;
        } else {
            List<Integer> preorderSubset = getPreOrderSubset(inorderRightList, preorderTraversal);
            root.right = constructTree(inorderRightList, preorderSubset);
        }

        return root;
    }

    private static List<Integer> getPreOrderSubset(final List<Integer> inorderLeftList,
                                                   final List<Integer> preorderTraversal) {
        List<Integer> preOrderLeftList = new ArrayList<>();
        for (Integer preOrderItem : preorderTraversal) {
            if (inorderLeftList.contains(preOrderItem)) {
                preOrderLeftList.add(preOrderItem);
            }
        }
        return preOrderLeftList;
    }

    private static List<Integer> getInorderRightList(List<Integer> inorderTraversal, int val) {
        List<Integer> subset = new ArrayList<>();
        int i = 0;
        while (i < inorderTraversal.size() && inorderTraversal.get(i) != val) {
            i++;
        }
        i++;
        while (i < inorderTraversal.size()) {
            subset.add(inorderTraversal.get(i));
            i++;
        }
        return subset;
    }

    private static List<Integer> getInorderLeftList(final List<Integer> inorderTraversal,
                                                    final int val) {
        List<Integer> subset = new ArrayList<>();
        int i = 0;
        while (i < inorderTraversal.size() && inorderTraversal.get(i) != val) {
            subset.add(inorderTraversal.get(i));
            i++;
        }
        return subset;
    }
}
