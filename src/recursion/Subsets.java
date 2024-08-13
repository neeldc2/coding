package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }

    private void findSubsets(int[] nums, List<List<Integer>> subsets, int i, List<Integer> temp) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        findSubsets(nums, subsets, i + 1, temp);
        temp.removeLast();
        findSubsets(nums, subsets, i + 1, temp);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> solution = subsets.subsets(new int[]{1, 2, 3});
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
