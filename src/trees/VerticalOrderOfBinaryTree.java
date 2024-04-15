package trees;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class VerticalOrderOfBinaryTree {

    private static List<List<Integer>> solution = new ArrayList<>();
    private static Map<Map.Entry<Integer, Integer>, List<BinaryTreeNode>> nodeLocation = new HashMap<>();
    private static Map<Integer, SortedSet<Integer>> xAndYAxisCombinations = new TreeMap<>();
    private static AtomicInteger maxLeft = new AtomicInteger(0);

    public static List<List<Integer>> verticalTraversal(BinaryTreeNode root) {
        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(0, 0);
        traverse(root, entry);
        int indexHelper = Math.abs(maxLeft.get());
        for (Map.Entry<Integer, SortedSet<Integer>> t : xAndYAxisCombinations.entrySet()) {
            Integer xInteger = t.getKey();
            SortedSet<Integer> yIntegers = t.getValue();

            Integer index = indexHelper + xInteger;
            List<Integer> yAxisValues = new ArrayList<>();
            for (Integer yInteger : yIntegers) {
                List<BinaryTreeNode> nodes = nodeLocation.get(new AbstractMap.SimpleEntry<>(xInteger, yInteger));
                List<Integer> nodeValues = nodes.stream().map(node -> node.val).sorted().toList();
                yAxisValues.addAll(nodeValues);
            }
            solution.add(index, yAxisValues);
        }
        return solution;
    }

    private static void traverse(BinaryTreeNode node, Map.Entry<Integer, Integer> pair) {
        nodeLocation.computeIfAbsent(pair, k -> new ArrayList<>()).add(node);

        Integer xInteger = pair.getKey();
        Integer yInteger = pair.getValue();
        xAndYAxisCombinations.computeIfAbsent(xInteger, k -> new TreeSet<>()).add(yInteger);

        if (maxLeft.get() > xInteger) {
            maxLeft.set(xInteger);
        }

        if (node.left != null) {
            traverse(node.left, new AbstractMap.SimpleEntry(xInteger - 1, yInteger + 1));
        }
        if (node.right != null) {
            traverse(node.right, new AbstractMap.SimpleEntry(xInteger + 1, yInteger + 1));
        }
    }

}
