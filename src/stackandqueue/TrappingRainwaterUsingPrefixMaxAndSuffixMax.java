package stackandqueue;

class TrappingRainwaterUsingPrefixMaxAndSuffixMax {
    public int trap(int[] height) {
        // No water can be trapped with less than 3 walls
        if (height == null || height.length < 2) {
            return 0;
        }

        int n = height.length;

        // Step 1: Initialize prefixMax and suffixMax arrays
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        // Step 2: Fill prefixMax array
        prefixMax[0] = 0;
        prefixMax[1] = height[0];
        for (int i = 2; i < n; i++) {
            prefixMax[i] = Math.max(height[i - 1], prefixMax[i - 1]);
        }

        // Step 3: Fill suffixMax array
        suffixMax[n - 1] = 0;
        suffixMax[n - 2] = height[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            suffixMax[i] = Math.max(height[i + 1], suffixMax[i + 1]);
        }

        // Step 4: Calculate trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(prefixMax[i], suffixMax[i]);
            totalWater += Math.max(0, waterLevel - height[i]);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainwaterUsingPrefixMaxAndSuffixMax trap = new TrappingRainwaterUsingPrefixMaxAndSuffixMax();
        System.out.println(trap.trap(new int[]{10, 0, 2, 0, 4}));
        System.out.println(trap.trap(new int[]{3, 0, 2, 1, 4}));
        System.out.println(trap.trap(new int[]{10, 0, 2, 1, 4}));
    }
}
