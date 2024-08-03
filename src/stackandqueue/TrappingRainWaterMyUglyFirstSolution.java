package stackandqueue;

public class TrappingRainWaterMyUglyFirstSolution {
    public int trap(int[] height) {
        int ans = 0;

        for (int i = 0; i < height.length; ) {
            int numberi = height[i];
            int j = i + 1;

            if (j >= height.length) {
                break;
            }
            int numberj = height[j];

            if (numberj >= numberi) {
                i++;
            } else {
                int maxInJ = numberj;
                int indexOfMaxJ = j;
                j++;
                for (; j < height.length; j++) {
                    numberj = height[j];

                    if (maxInJ <= numberj) {
                        maxInJ = numberj;
                        indexOfMaxJ = j;
                    }

                    if (numberj >= numberi) {
                        break;
                    }
                }

                if (j == height.length && (indexOfMaxJ - i) == 1) {
                    i++;
                } else if (j == height.length) {
                    for (int k = i + 1; k < indexOfMaxJ; k++) {
                        ans = ans + (Math.min(maxInJ, numberi) - height[k]);
                    }
                    i = indexOfMaxJ;
                } else {
                    for (int k = i + 1; k < j; k++) {
                        ans = ans + (numberi - height[k]);
                    }
                    i = j;
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        TrappingRainWaterMyUglyFirstSolution trap = new TrappingRainWaterMyUglyFirstSolution();
        System.out.println(trap.trap(new int[]{10, 0, 2, 0, 4}));
        System.out.println(trap.trap(new int[]{3, 0, 2, 1, 4}));
        System.out.println(trap.trap(new int[]{10, 0, 2, 1, 4}));
    }
}
