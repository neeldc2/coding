package recursion;

public class ReverseAnArray {

    private int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        perform(arr, reversedArray, 0);
        return reversedArray;
    }

    private void perform(int[] arr, int[] reversedArray, int i) {
        if (i == arr.length) {
            return;
        }
        reversedArray[arr.length - 1 - i] = arr[i];
        perform(arr, reversedArray, i+1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int[] newArr = reverseAnArray.reverse(arr);
        print(arr);
        print(newArr);
    }

    private static void print(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
