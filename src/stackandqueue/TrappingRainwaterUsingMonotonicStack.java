package stackandqueue;

import java.util.Stack;

class TrappingRainwaterUsingMonotonicStack {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int trappedHeight = Math.min(height[i], height[stack.peek()]) - height[bottom];
                water += width * trappedHeight;
            }
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainwaterUsingMonotonicStack trap = new TrappingRainwaterUsingMonotonicStack();
        System.out.println(trap.trap(new int[]{10,0,2,0,4}));
    }
}
