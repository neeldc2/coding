package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    private static void print(int[] arr) {
        List<Integer> newArr = new ArrayList<>();
        performAction(arr, 0, newArr);
    }

    private static void performAction(int[] arr, int i, List<Integer> newArr) {
        if (i >= arr.length) {
            if (newArr.isEmpty()) {
                System.out.println("Empty List");
                return;
            }
            for (int a : newArr) {
                System.out.print(a);
            }
            System.out.println();
            return;
        }

        newArr.add(arr[i]);
        performAction(arr, i+1, newArr);

        newArr.removeLast();
        performAction(arr, i+1, newArr);
    }

    public static void main(String[] args) {
        Subsequences.print(new int[]{3, 1, 2});
    }
}
