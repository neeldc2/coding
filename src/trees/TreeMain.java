package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeMain {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        System.out.println("Level Order Traversal");
        {
            List<Integer> levelOrderTraversal = LevelOrderTraversal.traverse(root);
            printTraversal(levelOrderTraversal);
        }

        System.out.println("Inorder Traversal");
        {
            List<Integer> inorderTraversal = InorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(inorderTraversal);

            inorderTraversal = InorderTraversal.iterativeTraversal(root);
            printTraversal(inorderTraversal);
        }

        System.out.println("Preorder Traversal");
        {
            List<Integer> preorderTraversal = PreorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(preorderTraversal);

            preorderTraversal = PreorderTraversal.iterativeTraversal(root);
            printTraversal(preorderTraversal);
        }

        System.out.println("Postorder Traversal");
        {
            List<Integer> postorderTraversal = PostorderTraversal.recursiveTraversal(root, new ArrayList<>());
            printTraversal(postorderTraversal);

            postorderTraversal = PostorderTraversal.iterativeTraversal(root);
            printTraversal(postorderTraversal);

            postorderTraversal = PostorderTraversal.iterativeTraversalWithTwoStacks(root);
            printTraversal(postorderTraversal);
        }

        System.out.println("All traversals in one");
        {
            ThreeDFSTraversalInOne.allTraversals(root);
        }


        {
            int maxDepth = MaxDepth.maxDepthUsingLevelOrderTraversal(root);
            System.out.println("Max Depth of Binary tree: " + maxDepth);

            maxDepth = MaxDepth.maxDepthUsingRecursion(root);
            System.out.println("Max Depth of Binary tree: " + maxDepth);
        }

        {
            boolean isBalancedBinaryTree = BalancedBinaryTree.isBinaryTreeBalanced(root);
            System.out.println("Is the Binary Tree Balanced: " + isBalancedBinaryTree);
        }
    }

    public static void printTraversal(List<Integer> traversal) {
        System.out.println(
                traversal.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }

}
