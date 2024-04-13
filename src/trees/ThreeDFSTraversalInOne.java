package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeDFSTraversalInOne {

    /**
     * If position is 1, add to pre and move left
     * If position is 2, add to in and move right
     * If position is 3, add to post
     * Source: https://www.youtube.com/watch?v=1i8E4mJ9x3o&ab_channel=Yogesh%26Shailesh%28CodeLibrary%29
     *
     * @param root
     */
    public static void allTraversals(BinaryTreeNode root) {
        List<Integer> preorderTraversal = new ArrayList<>();
        List<Integer> inorderTraversal = new ArrayList<>();
        List<Integer> postorderTraversal = new ArrayList<>();
        Stack<BinaryTreeAndItsPositionNumber> stack = new Stack<>();

        BinaryTreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(new BinaryTreeAndItsPositionNumber(node, 1));
            }
            BinaryTreeAndItsPositionNumber binaryTreeAndItsPositionNumber = stack.pop();

            if (binaryTreeAndItsPositionNumber.position() == 1) {
                preorderTraversal.add(binaryTreeAndItsPositionNumber.node().val);
                stack.push(new BinaryTreeAndItsPositionNumber(node, 2));
                node = node.left;
            } else if (binaryTreeAndItsPositionNumber.position() == 2) {
                inorderTraversal.add(binaryTreeAndItsPositionNumber.node().val);
                stack.push(new BinaryTreeAndItsPositionNumber(binaryTreeAndItsPositionNumber.node(), 3));
                node = binaryTreeAndItsPositionNumber.node().right;
            } else {
                postorderTraversal.add(binaryTreeAndItsPositionNumber.node().val);
            }

        }

        TreeMain.printTraversal(preorderTraversal);
        TreeMain.printTraversal(inorderTraversal);
        TreeMain.printTraversal(postorderTraversal);
    }

}

record BinaryTreeAndItsPositionNumber(BinaryTreeNode node, Integer position) {
}
