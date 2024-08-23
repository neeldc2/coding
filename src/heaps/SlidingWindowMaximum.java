package heaps;

import java.util.PriorityQueue;
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
        PriorityQueue<ValueIndexPair> queue = new PriorityQueue<>((a, b) -> b.value() - a.value());
        int[] response = new int[nums.length - k + 1];

        for (int i = 0 ; i < k ; i++) {
            queue.add(new ValueIndexPair(nums[i], i));
        }
        response[0] = queue.peek().value();

        for (int i = 1 ; i < nums.length - k + 1 ; i++) {
            int startIndex = i;
            int endIndex = i + k -1;

            int currentMaxElementIndex = queue.peek().index();

            while (currentMaxElementIndex < startIndex) {
                queue.poll();

                if (queue.isEmpty()) {
                    break;
                }
                currentMaxElementIndex = queue.peek().index();
            }

            queue.offer(new ValueIndexPair(nums[endIndex], endIndex));
            response[i] = queue.peek().value();
        }

        return response;
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

record ValueIndexPair(int value, int index) {
}
