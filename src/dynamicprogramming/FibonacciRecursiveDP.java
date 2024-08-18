package dynamicprogramming;

import java.util.HashMap;

public class FibonacciRecursiveDP {

    public static void main(String[] args) {
        System.out.print(fibonacci(100L, new HashMap<>()) + " ");
    }

    public static Long fibonacci(Long n, HashMap<Long, Long> memo) {
        // Base cases
        if (n == 0) return 0L;
        if (n == 1) return 1L;

        // Check if the value is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Compute the value and store it in the memoization map
        Long result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);

        return result;
    }

}
