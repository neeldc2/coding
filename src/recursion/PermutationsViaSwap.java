package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationsViaSwap {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        permute(nums, solution, 0);
        return solution;
    }

    private void permute(int[] nums, List<List<Integer>> solution, int i) {
        if (i == nums.length - 1) {
            solution.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int k = i ; k < nums.length ; k++) {
            swap(nums, i, k);
            permute(nums, solution, i + 1);
            swap(nums, k, i);
        }
    }

    private void swap(int[] nums, int i, int k) {
        if (i == k) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        PermutationsViaSwap permutations = new PermutationsViaSwap();
        List<List<Integer>> solution = permutations.permute(new int[]{10, 20, 30});
        print(solution);

        System.out.println("---------------");

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
