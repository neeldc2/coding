package stackandqueue;

public class TrappingRainWaterTwoPointerApproach {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWaterTwoPointerApproach trap = new TrappingRainWaterTwoPointerApproach();
        System.out.println(trap.trap(new int[]{10, 0, 2, 0, 4}));
        System.out.println(trap.trap(new int[]{3, 0, 2, 1, 4}));
        System.out.println(trap.trap(new int[]{10, 0, 2, 1, 4}));
    }
}
