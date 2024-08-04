package stackandqueue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<ValueIndexPair> stack = new Stack();
        int maxArea = 0;

        if (heights[0] > 0) {
            stack.push(new ValueIndexPair(heights[0], 0));
        }
        for (int i = 1; i < heights.length; i++) {
            int currentHeight = heights[i];

            if (stack.isEmpty()) {
                if (currentHeight != 0) {
                    stack.push(new ValueIndexPair(currentHeight, i));
                }
                continue;
            }

            ValueIndexPair stackTop = stack.peek();

            if (currentHeight > stackTop.value()) {
                stack.push(new ValueIndexPair(currentHeight, i));
            } else {
                int lastIndex = i;
                while (stackTop.value() >= currentHeight) {
                    ValueIndexPair valueIndexPair = stack.pop();
                    lastIndex = valueIndexPair.index();
                    int tempMaxArea = (i - valueIndexPair.index()) * valueIndexPair.value();
                    maxArea = Math.max(maxArea, tempMaxArea);

                    if (stack.isEmpty()) {
                        break;
                    }
                    stackTop = stack.peek();
                }
                if (currentHeight != 0) {
                    stack.push(new ValueIndexPair(currentHeight, lastIndex));
                }
            }
        }

        while (!stack.isEmpty()) {
            ValueIndexPair valueIndexPair = stack.pop();
            int tempMaxArea = (heights.length - valueIndexPair.index()) * valueIndexPair.value();
            maxArea = Math.max(maxArea, tempMaxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram area = new LargestRectangleInHistogram();
        System.out.println(area.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3, 4, 1, 3, 8, 1}));
    }

}

record ValueIndexPair(Integer value, Integer index) {
}