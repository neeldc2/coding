package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfSumKPrintCount {

    private static List<Integer> newArr = new ArrayList<>();
    private static int sum;
    private static int count;

    private static void print(int[] arr, int sumK) {
        sum = sumK;
        count = 0;
        performAction(arr, 0);
    }

    private static void performAction(int[] arr, int i) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return;
            }
            int tempSum = newArr.stream().mapToInt(a -> a).sum();
            if (tempSum == sum) {
                count++;
            }
            return;
        }

        newArr.add(arr[i]);
        performAction(arr, i + 1);

        newArr.removeLast();
        performAction(arr, i + 1);
    }

    public static void main(String[] args) {
        SubsequencesOfSumKPrintCount.print(new int[]{3, 1, 2}, 5);
        System.out.println(count);
        SubsequencesOfSumKPrintCount.print(new int[]{3, 1, 2}, 3);
        System.out.println(count);
    }

}
