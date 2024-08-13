package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        performAction(candidates, 0, new ArrayList<>(), target, solution);
        return solution;
    }

    private static void performAction(int[] arr, int i, List<Integer> newArr, int sum, List<List<Integer>> solution) {
        if (i >= arr.length) {
            if (sum == 0) {
                // Very Important step
                solution.add(new ArrayList<>(newArr));
                return;
            }
            return;
        }

        newArr.add(arr[i]);
        if (sum - arr[i] >= 0) {
            performAction(arr, i, newArr, sum - arr[i], solution);
        }

        newArr.removeLast();
        performAction(arr, i + 1, newArr, sum, solution);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> solution = combinationSum.combinationSum(new int[]{3, 1, 2}, 6);
        print(solution);
    }

    private static void print(List<List<Integer>> solution) {
        for (List<Integer> firstList : solution) {
            for (Integer i : firstList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
