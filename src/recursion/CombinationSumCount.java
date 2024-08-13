package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * This is not a leetcode Combination Sum problem.
 * This is the continuation of Sequences of Sum K Count Problem.
 * This will print all the combinations possible as well as count it.
 */
public class CombinationSumCount {

    private static int getCount(int[] arr, int sumK) {
        List<Integer> newArr = new ArrayList<>();
        return performAction(arr, 0, newArr, sumK);
    }

    private static int performAction(int[] arr, int i, List<Integer> newArr, int sum) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return 0;
            }
            if (sum == 0) {
                System.out.println(newArr);
                return 1;
            }
            return 0;
        }

        newArr.add(arr[i]);
        int count1 = 0;
        if (sum - arr[i] >= 0) {
            count1 = performAction(arr, i, newArr, sum - arr[i]);
        }


        newArr.removeLast();
        int count2 = performAction(arr, i + 1, newArr, sum);

        return count1 + count2;
    }

    public static void main(String[] args) {
        int count;
        count = CombinationSumCount.getCount(new int[]{3, 1, 2}, 6);
        System.out.println(count);
        count = CombinationSumCount.getCount(new int[]{3, 1, 2}, 5);
        System.out.println(count);
        count = CombinationSumCount.getCount(new int[]{3, 1, 2}, 3);
        System.out.println(count);
    }

}
