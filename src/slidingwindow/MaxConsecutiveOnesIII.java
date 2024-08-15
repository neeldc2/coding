package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int maxOnes = 0;
        int startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];

            if (currentElement == 1) {
                maxOnes = getMax(maxOnes, startIndex, i);
            } else {
                if (k == 0) {
                    startIndex = i + 1;
                } else if (queue.size() < k) {
                    queue.add(i);
                    maxOnes = getMax(maxOnes, startIndex, i);
                } else {
                    int elementRemovedFromQueue = queue.remove();
                    queue.add(i);
                    startIndex = elementRemovedFromQueue + 1;
                }
            }
        }

        return maxOnes;
    }

    private int getMax(int maxOnes, int startIndex, int currentIndex) {
        int currentLength = currentIndex - startIndex + 1;
        return Math.max(currentLength, maxOnes);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
