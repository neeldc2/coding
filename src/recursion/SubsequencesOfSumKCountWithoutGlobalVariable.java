package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SubsequencesOfSumKCountWithoutGlobalVariable {

    private static int print(int[] arr, int sumK) {
        List<Integer> newArr = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);
        performAction(arr, 0, newArr, sumK, count);
        return count.get();
    }

    private static void performAction(int[] arr, int i, List<Integer> newArr, int sum, AtomicInteger count) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return;
            }
            int tempSum = newArr.stream().mapToInt(a -> a).sum();
            if (tempSum == sum) {
                count.set(count.get() + 1);
                return;
            }
            return;
        }

        newArr.add(arr[i]);
        performAction(arr, i + 1, newArr, sum, count);

        newArr.removeLast();
        performAction(arr, i + 1, newArr, sum, count);
    }

    public static void main(String[] args) {
        int count;
        count = SubsequencesOfSumKCountWithoutGlobalVariable.print(new int[]{3, 1, 2}, 6);
        System.out.println(count);
        count = SubsequencesOfSumKCountWithoutGlobalVariable.print(new int[]{3, 1, 2}, 5);
        System.out.println(count);
        count = SubsequencesOfSumKCountWithoutGlobalVariable.print(new int[]{3, 1, 2}, 3);
        System.out.println(count);
    }

}
