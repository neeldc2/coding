package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        permute(nums, solution, 0, new HashSet<>(), new ArrayList<>());
        return solution;
    }

    private void permute(int[] nums, List<List<Integer>> solution, int i, Set<Integer> coveredIndexes, List<Integer> temp) {
        if (i == nums.length) {
            solution.add(new ArrayList<>(temp));
            return;
        }

        for (int k = 0; k < nums.length; k++) {
            if (!coveredIndexes.contains(k)) {
                coveredIndexes.add(k);
                temp.add(nums[k]);
                permute(nums, solution, i + 1, coveredIndexes, temp);
                coveredIndexes.remove(k);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Permutations subsets = new Permutations();
        List<List<Integer>> solution = subsets.permute(new int[]{10, 20, 30});
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
