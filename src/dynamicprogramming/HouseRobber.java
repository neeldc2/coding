package dynamicprogramming;

import java.util.concurrent.atomic.AtomicInteger;

public class HouseRobber {

    public int rob(int[] nums) {
        AtomicInteger maxMoney = new AtomicInteger(0);
        if (nums.length == 1) {
            return nums[0];
        }
        int firstElement = nums[0];
        int secondElement = nums[1];

        if (firstElement < secondElement) {
            maxMoney.set(Math.max(nums[1], maxMoney.get()));
            calculate(nums, maxMoney, 0, nums[0], true);
            calculate(nums, maxMoney, 1, nums[1], false);
        } else if (secondElement < firstElement) {
            maxMoney.set(Math.max(nums[0], maxMoney.get()));
            calculate(nums, maxMoney, 0, nums[0], false);
        } else {
            maxMoney.set(Math.max(nums[0], maxMoney.get()));
            calculate(nums, maxMoney, 0, nums[0], false);
            //calculate(nums, maxMoney, 1, nums[1], false);
        }

        return maxMoney.get();
    }

    public void calculate(int[] nums, AtomicInteger maxMoney, int i, int sum, boolean skipRight) {
        int firstIndex = i + 2;
        int secondIndex = i + 3;

        int maxLength = nums.length;

        if (secondIndex >= maxLength) {
            if (firstIndex < maxLength) {
                sum += nums[firstIndex];
                maxMoney.set(Math.max(sum, maxMoney.get()));
                return;
            }
        } else {
            int firstElement = nums[firstIndex];
            int secondElement = nums[secondIndex];

            if (skipRight) {
                sum += nums[firstIndex];
                maxMoney.set(Math.max(sum, maxMoney.get()));
                calculate(nums, maxMoney, firstIndex, sum, false);
            } else {
                if (firstElement < secondElement) {
                    sum += nums[firstIndex];
                    maxMoney.set(Math.max(sum, maxMoney.get()));
                    calculate(nums, maxMoney, firstIndex, sum, true);
                    sum -= nums[firstIndex];
                    sum += nums[secondIndex];
                    maxMoney.set(Math.max(sum, maxMoney.get()));
                    calculate(nums, maxMoney, secondIndex, sum, false);
                } else if (secondElement < firstElement) {
                    sum += nums[firstIndex];
                    maxMoney.set(Math.max(sum, maxMoney.get()));
                    calculate(nums, maxMoney, firstIndex, sum, false);
                } else {
                    sum += nums[firstIndex];
                    maxMoney.set(Math.max(sum, maxMoney.get()));
                    calculate(nums, maxMoney, firstIndex, sum, false);
                    //calculate(nums, maxMoney, secondIndex, sum, false);
                }
            }
        }
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1, 3, 1, 3, 100}));
        System.out.println(robber.rob(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37,
                157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55,
                209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192,
                125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10,
                82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124}));
        System.out.println(robber.rob(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(robber.rob(new int[]{6, 6, 4, 8, 4, 3, 3, 10}));
    }
}
