package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfSumKPrintOneWithoutGlobalVariable {

    private static void print(int[] arr, int sumK) {
        List<Integer> newArr = new ArrayList<>();
        performAction(arr, 0, newArr, sumK);
    }

    private static boolean performAction(int[] arr, int i, List<Integer> newArr, int sum) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                return false;
            }
            int tempSum = newArr.stream().mapToInt(a -> a).sum();
            if (tempSum == sum) {
                for (int a : newArr) {
                    System.out.print(a);
                }
                System.out.println();
                return true;
            }
            return false;
        }

        newArr.add(arr[i]);
        boolean response = performAction(arr, i + 1, newArr, sum);

        if (response) {
            //System.out.println("Skipping");
            return response;
        }

        newArr.removeLast();
        response = performAction(arr, i + 1, newArr, sum);

        return response;
    }

    public static void main(String[] args) {
        SubsequencesOfSumKPrintOneWithoutGlobalVariable.print(new int[]{3, 1, 2}, 6);
        SubsequencesOfSumKPrintOneWithoutGlobalVariable.print(new int[]{3, 1, 2}, 5);
        SubsequencesOfSumKPrintOneWithoutGlobalVariable.print(new int[]{3, 1, 2}, 3);
    }

}
