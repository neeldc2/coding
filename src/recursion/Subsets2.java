package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(List.of());
        findSubsets(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }

    private void findSubsets(int[] nums, List<List<Integer>> subsets, int i, List<Integer> temp) {
        if (i == nums.length) {
            return;
        }

        Set<Integer> tempSet = new HashSet<>();
        for (int k = i ; k < nums.length; k++) {
            if (!tempSet.contains(nums[k])) {
                tempSet.add(nums[k]);
                temp.add(nums[k]);
                addToSubsets(temp, subsets);
                findSubsets(nums, subsets, k+1, temp);
                temp.removeLast();
            }
        }
    }

    private void addToSubsets(List<Integer> temp, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(temp));
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        List<List<Integer>> solution = subsets.subsetsWithDup(new int[]{1, 2, 2});
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
