package recursion;

public class ReverseAnArrayInPlace {

    private void reverse(int[] arr) {
        perform(arr, 0);
    }

    private void perform(int[] arr, int i) {
        int rightPointer = arr.length - 1 - i;
        if (i >= rightPointer) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[rightPointer];
        arr[rightPointer] = temp;
        perform(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        print(arr);
        ReverseAnArrayInPlace reverseAnArray = new ReverseAnArrayInPlace();
        reverseAnArray.reverse(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
