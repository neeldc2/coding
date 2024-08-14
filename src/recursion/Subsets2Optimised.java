package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2Optimised {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }
    private void findSubsets(int[] nums, List<List<Integer>> subsets, int i, List<Integer> temp) {
        subsets.add(new ArrayList<>(temp));

        for (int k = i ; k < nums.length; k++) {
            if (i == k || nums[k] > nums[k-1]) {
                temp.add(nums[k]);
                findSubsets(nums, subsets, k+1, temp);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Subsets2Optimised subsets = new Subsets2Optimised();
        List<List<Integer>> solution = subsets.subsetsWithDup(new int[]{1, 2, 2});
        print(solution);

        System.out.println("---------------");

        solution = subsets.subsetsWithDup(new int[]{4, 4, 4, 1, 4});
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
