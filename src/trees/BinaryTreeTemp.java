package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BinaryTreeTemp {
    protected int data;
    protected BinaryTreeTemp left;
    protected BinaryTreeTemp right;

    public BinaryTreeTemp(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static List<Integer> levelOrderTraversal(BinaryTreeTemp root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> levelOrderTraversal = new ArrayList<>();

        Queue<BinaryTreeTemp> queueForStorage = new LinkedList<>();
        queueForStorage.add(root);

        while (!queueForStorage.isEmpty()) {
            BinaryTreeTemp node = queueForStorage.poll();
            levelOrderTraversal.add(node.data);

            if (node.left != null) {
                queueForStorage.add(node.left);
            }
            if (node.right != null) {
                queueForStorage.add(node.right);
            }
        }

        return levelOrderTraversal;
    }

    public static List<Integer> preOrderTraversal(BinaryTreeTemp root) {
        Stack<BinaryTreeTemp> stack = new Stack<>();
        List<Integer> preorderTraversal = new ArrayList<>();

        if (root == null) {
            return preorderTraversal;
        }

        BinaryTreeTemp node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                preorderTraversal.add(node.data);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }

        return preorderTraversal;
    }


    public static List<Integer> preOrderTraversal2(BinaryTreeTemp root) {
        Stack<BinaryTreeTemp> stack = new Stack<>();
        List<Integer> preorderTraversal = new ArrayList<>();
        if (root == null) {
            return preorderTraversal;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeTemp node = stack.pop();
            preorderTraversal.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorderTraversal;
    }

    public static List<Integer> inorderTraversal(BinaryTreeTemp root) {
        Stack<BinaryTreeTemp> stack = new Stack<>();
        List<Integer> inorderTraversal = new ArrayList<>();
        if (root == null) {
            return inorderTraversal;
        }

        BinaryTreeTemp node = root;

        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                inorderTraversal.add(node.data);
                node = node.right;
            }
        }

        return inorderTraversal;
    }

    public static int maxDepthUsingLevelOrderTraversal(BinaryTreeTemp root) {
        int maxDepth = 0;

        if (root == null) {
            return maxDepth;
        }

        List<List<BinaryTreeTemp>> lists = new ArrayList<>();
        lists.add(List.of(root));

        for (int i = 0; i < lists.size(); i++) {
            List<BinaryTreeTemp> currentLevelNodes = lists.get(i);

            List<BinaryTreeTemp> nextLevel = new ArrayList<>();
            for (BinaryTreeTemp tempNode : currentLevelNodes) {
                if (tempNode.right != null) {
                    nextLevel.add(tempNode.right);
                }
                if (tempNode.left != null) {
                    nextLevel.add(tempNode.left);
                }
            }

            if (nextLevel.size() > 0) {
                lists.add(nextLevel);
            }
        }

        return lists.size();
    }

    public static int maxDepthUsingRecursion(BinaryTreeTemp root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
                maxDepthUsingRecursion(root.left),
                maxDepthUsingRecursion(root.right));
    }

    public static boolean isBalancedTree(BinaryTreeTemp root) {
        if (root == null) {
            return true;
        }

        int leftDepth = maxDepthUsingRecursion(root.left);
        int rightDepth = maxDepthUsingRecursion(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return true;
    }

    static AtomicInteger diameter = new AtomicInteger(0);

    public static int getDiameter(BinaryTreeTemp root) {
        if (root == null) {
            return 0;
        }

        getMaxDepth(root);
        return diameter.get();
    }

    public static int getMaxDepth(BinaryTreeTemp node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);

        diameter.set(Math.max(diameter.get(), 1 + leftDepth + rightDepth));

        return 1 + Math.max(leftDepth, rightDepth);
    }

    static Integer maxPathSum = 0;

    public static int getMaxPath(BinaryTreeTemp root) {
        if (root == null) {
            return 0;
        }

        getMaxDepthForSum(root);
        return maxPathSum;
    }

    public static int getMaxDepthForSum(BinaryTreeTemp node) {
        if (node == null) {
            return 0;
        }

        maxPathSum = Math.max(maxPathSum, node.data);

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftDepthSum = getMaxDepthForSum(node.left);
        int rightDepthSum = getMaxDepthForSum(node.right);

        maxPathSum = Math.max(maxPathSum, leftDepthSum + node.data);
        maxPathSum = Math.max(maxPathSum, rightDepthSum + node.data);
        maxPathSum = Math.max(maxPathSum, leftDepthSum + rightDepthSum + node.data);

        return Math.max(Math.max(leftDepthSum + node.data, rightDepthSum + node.data), node.data);
    }

    public static void main(String[] args) {
        BinaryTreeTemp root = new BinaryTreeTemp(1);
        root.left = new BinaryTreeTemp(2);
        root.right = new BinaryTreeTemp(3);
        root.left.left = new BinaryTreeTemp(4);
        root.left.right = new BinaryTreeTemp(5);
        root.right.right = new BinaryTreeTemp(6);
        root.right.left = new BinaryTreeTemp(2);

        System.out.print("Level Order Traversal: ");
        {
            List<Integer> levelOrderTraversal = levelOrderTraversal(root);
            printTraversal(levelOrderTraversal);
        }

        System.out.println("maxDepth: " + maxDepthUsingLevelOrderTraversal(root));
    }

    public static void printTraversal(List<Integer> traversal) {
        System.out.println(
                traversal.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }
}
