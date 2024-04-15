package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BottomViewBinaryTree {

    private static List<Integer> bottomView = new ArrayList<>();

    public static List<Integer> getView(BinaryTreeNode root) {
        TreeMap<Integer, Integer> bottomViewMap = traverse(root);
        bottomViewMap.forEach((key, value) -> bottomView.add(value));
        return bottomView;
    }

    private static TreeMap<Integer, Integer> traverse(BinaryTreeNode root) {
        List<List<NodeWithPositionInfoForBottomView>> queueList = new ArrayList<>();
        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();

        List<NodeWithPositionInfoForBottomView> nodeWithPositionInfos = new ArrayList<>();
        nodeWithPositionInfos.add(new NodeWithPositionInfoForBottomView(root, 0, 0));
        queueList.add(nodeWithPositionInfos);

        bottomViewMap.put(0, root.val);

        for (int i = 0; i < queueList.size(); i++) {
            nodeWithPositionInfos = queueList.get(i);

            List<NodeWithPositionInfoForBottomView> newNodeWithPositionInfoList = new ArrayList<>();
            for (int j = 0; j < nodeWithPositionInfos.size(); j++) {
                NodeWithPositionInfoForBottomView nodeWithPositionInfo = nodeWithPositionInfos.get(j);
                BinaryTreeNode node = nodeWithPositionInfo.node();
                Integer xIndex = nodeWithPositionInfo.xIndex();
                Integer yIndex = nodeWithPositionInfo.yIndex();

                if (node.left != null) {
                    bottomViewMap.put(xIndex - 1, node.left.val);
                    nodeWithPositionInfos.add(new NodeWithPositionInfoForBottomView(node.left, xIndex - 1, yIndex + 1));
                }
                if (node.right != null) {
                    bottomViewMap.put(xIndex + 1, node.right.val);
                    nodeWithPositionInfos.add(new NodeWithPositionInfoForBottomView(node.right, xIndex + 1, yIndex + 1));
                }
            }
            if (!newNodeWithPositionInfoList.isEmpty()) {
                queueList.add(newNodeWithPositionInfoList);
            }
        }

        return bottomViewMap;
    }

}

record NodeWithPositionInfoForBottomView(BinaryTreeNode node, Integer xIndex, Integer yIndex) {
}
