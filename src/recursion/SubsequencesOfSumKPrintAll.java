package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfSumKPrintAll {

    private static List<Integer> newArr;
    private static int sum;

    private static void print(int[] arr, int sumK) {
        newArr = new ArrayList<>();
        sum = sumK;
        performAction(arr, 0);
    }

    private static void performAction(int[] arr, int i) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return;
            }
            int tempSum = newArr.stream().mapToInt(a -> a).sum();
            if (tempSum == sum) {
                for (int a : newArr) {
                    System.out.print(a);
                }
                System.out.println();
            }
            return;
        }

        newArr.add(arr[i]);
        performAction(arr, i + 1);

        newArr.removeLast();
        performAction(arr, i + 1);
    }

    public static void main(String[] args) {
        SubsequencesOfSumKPrintAll.print(new int[]{3, 1, 2}, 5);
        SubsequencesOfSumKPrintAll.print(new int[]{3, 1, 2}, 3);
    }

}
