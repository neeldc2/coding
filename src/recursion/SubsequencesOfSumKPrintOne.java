package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfSumKPrintOne {

    private static List<Integer> newArr;
    private static int sum;
    private static boolean found;

    private static void print(int[] arr, int sumK) {
        newArr = new ArrayList<>(); // This is needed because the previous iteration does not clear all the elements
        sum = sumK;
        found = false;
        performAction(arr, 0);
    }

    private static void performAction(int[] arr, int i) {
        if (found) {
            return;
        }

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
                found = true;
            }
            return;
        }

        newArr.add(arr[i]);
        performAction(arr, i + 1);

        if (found) {
            return;
        }

        newArr.removeLast();
        performAction(arr, i + 1);
    }

    public static void main(String[] args) {
        SubsequencesOfSumKPrintOne.print(new int[]{3, 1, 2}, 5);
        SubsequencesOfSumKPrintOne.print(new int[]{3, 1, 2}, 3);
    }

}
