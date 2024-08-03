package stackandqueue;

import java.util.Stack;

public class SumOfSubArrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1_000_000_007;

        int n = arr.length;
        long result = 0;
        Stack<Integer> stack = new Stack<>();

        // Arrays to store the distance to the next and previous smaller element
        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        // Clear the stack for reuse
        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Calculate the sum of minimums
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        SumOfSubArrayMinimums sum = new SumOfSubArrayMinimums();
        System.out.println(sum.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
