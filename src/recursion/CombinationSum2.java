package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(candidates);
        performAction(candidates, 0, new ArrayList<>(), target, solution);
        return solution;
    }

    private static void performAction(int[] arr, int i, List<Integer> newArr, int sum, List<List<Integer>> solution) {
        if (sum == 0) {
            // Very Important step
            solution.add(new ArrayList<>(newArr));
            return;
        }

        if (i >= arr.length) {
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int k = i ; k < arr.length ; k++) {
            if (!set.contains(arr[k]) && (sum - arr[k] >= 0)) {
                set.add(arr[k]);
                newArr.add(arr[k]);
                performAction(arr, k + 1, newArr, sum - arr[k], solution);
                newArr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        List<List<Integer>> solution = combinationSum.combinationSum(new int[]{1, 2, 1, 2, 1}, 4);
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
