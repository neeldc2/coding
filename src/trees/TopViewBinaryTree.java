package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TopViewBinaryTree {

    private static List<Integer> topView = new ArrayList<>();

    public static List<Integer> getView(BinaryTreeNode root) {
        TreeMap<Integer, Integer> topViewMap = traverse(root);
        topViewMap.forEach((key, value) -> topView.add(value));
        return topView;
    }

    private static TreeMap<Integer, Integer> traverse(BinaryTreeNode root) {
        List<List<NodeWithPositionInfo>> queueList = new ArrayList<>();
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();

        List<NodeWithPositionInfo> nodeWithPositionInfos = new ArrayList<>();
        nodeWithPositionInfos.add(new NodeWithPositionInfo(root, 0, 0));
        queueList.add(nodeWithPositionInfos);

        topViewMap.put(0, root.val);

        for (int i = 0; i < queueList.size(); i++) {
            nodeWithPositionInfos = queueList.get(i);

            List<NodeWithPositionInfo> newNodeWithPositionInfoList = new ArrayList<>();
            for (int j = 0; j < nodeWithPositionInfos.size(); j++) {
                NodeWithPositionInfo nodeWithPositionInfo = nodeWithPositionInfos.get(j);
                BinaryTreeNode node = nodeWithPositionInfo.node();
                Integer xIndex = nodeWithPositionInfo.xIndex();
                Integer yIndex = nodeWithPositionInfo.yIndex();

                if (node.left != null) {
                    if (!topViewMap.containsKey(xIndex - 1)) {
                        topViewMap.put(xIndex - 1, node.left.val);
                    }
                    nodeWithPositionInfos.add(new NodeWithPositionInfo(node.left, xIndex - 1, yIndex + 1));
                }
                if (node.right != null) {
                    if (!topViewMap.containsKey(xIndex + 1)) {
                        topViewMap.put(xIndex + 1, node.right.val);
                    }
                    nodeWithPositionInfos.add(new NodeWithPositionInfo(node.right, xIndex + 1, yIndex + 1));
                }
            }
            if (!newNodeWithPositionInfoList.isEmpty()) {
                queueList.add(newNodeWithPositionInfoList);
            }
        }

        return topViewMap;
    }

}

record NodeWithPositionInfo(BinaryTreeNode node, Integer xIndex, Integer yIndex) {
}
