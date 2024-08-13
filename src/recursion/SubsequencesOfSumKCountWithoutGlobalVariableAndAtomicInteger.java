package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SubsequencesOfSumKCountWithoutGlobalVariableAndAtomicInteger {

    private static int print(int[] arr, int sumK) {
        List<Integer> newArr = new ArrayList<>();
        return performAction(arr, 0, newArr, sumK);
    }

    private static int performAction(int[] arr, int i, List<Integer> newArr, int sum) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return 0;
            }
            int tempSum = newArr.stream().mapToInt(a -> a).sum();
            if (tempSum == sum) {
                return 1;
            }
            return 0;
        }

        newArr.add(arr[i]);
        int count1 = performAction(arr, i + 1, newArr, sum);

        newArr.removeLast();
        int count2 = performAction(arr, i + 1, newArr, sum);

        return count1 + count2;
    }

    public static void main(String[] args) {
        int count;
        count = SubsequencesOfSumKCountWithoutGlobalVariableAndAtomicInteger.print(new int[]{3, 1, 2}, 6);
        System.out.println(count);
        count = SubsequencesOfSumKCountWithoutGlobalVariableAndAtomicInteger.print(new int[]{3, 1, 2}, 5);
        System.out.println(count);
        count = SubsequencesOfSumKCountWithoutGlobalVariableAndAtomicInteger.print(new int[]{3, 1, 2}, 3);
        System.out.println(count);
    }

}
