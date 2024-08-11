package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesGlobalVariable {

    private static List<Integer> newArr = new ArrayList<>();

    private static void print(int[] arr) {
        performAction(arr, 0);
    }

    private static void performAction(int[] arr, int i) {
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
        performAction(arr, i + 1);

        newArr.removeLast();
        performAction(arr, i + 1);
    }

    public static void main(String[] args) {
        SubsequencesGlobalVariable.print(new int[]{3, 1, 2});
    }

}
