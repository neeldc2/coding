package stackandqueue;

import java.util.Stack;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nextGreaterElementIndex = new int[nums.length];
        int[] maxSlidingWindow = new int[nums.length - k + 1];
        Stack<Integer> stack = new Stack();

        // find NGE
        stack.push(nums.length - 1);
        nextGreaterElementIndex[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int currentElement = nums[i];

            // check if Stack is Empty

            int stackTopIndex = stack.peek();
            int stackTopElement = nums[stackTopIndex];

            if (currentElement < stackTopElement) {
                nextGreaterElementIndex[i] = stackTopIndex;
                stack.push(i);
            } else {
                while (currentElement > stackTopElement) {
                    stack.pop();

                    if (stack.isEmpty()) {
                        break;
                    }

                    stackTopIndex = stack.peek();
                    stackTopElement = nums[stackTopIndex];
                }

                if (stack.isEmpty()) {
                    nextGreaterElementIndex[i] = -1;
                } else {
                    nextGreaterElementIndex[i] = stackTopIndex;
                }
                stack.push(i);
            }
        }

        // calculate max sliding window
        for (int i = 0; i < (nums.length - k + 1); i++) {
            // calculate INCLUSIVE range
            int minRange = i;
            int maxRange = i + k - 1;

            int max = nums[i];
            int nextGreaterEleIndex = nextGreaterElementIndex[i];
            while (nextGreaterEleIndex >= minRange && nextGreaterEleIndex <= maxRange) {
                max = nums[nextGreaterEleIndex];
                nextGreaterEleIndex = nextGreaterElementIndex[nextGreaterEleIndex];
            }

            maxSlidingWindow[i] = max;
        }

        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum maxArray = new SlidingWindowMaximum();
        print(maxArray.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    private static void print(int[] ints) {
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
