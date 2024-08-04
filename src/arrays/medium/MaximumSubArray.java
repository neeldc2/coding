package arrays.medium;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int currentMax = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > currentMax) {
                currentMax = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return currentMax;
    }

    public static void main(String[] args) {
        MaximumSubArray sum = new MaximumSubArray();
        System.out.println(sum.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(sum.maxSubArray(new int[]{1}));
        System.out.println(sum.maxSubArray(new int[]{5,4,-1,7,8}));
    }

}
