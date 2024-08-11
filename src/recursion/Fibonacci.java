package recursion;

public class Fibonacci {

    public static int find(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        return find(n - 1) + find(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(find(1));
        System.out.println(find(2));
        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
        System.out.println(find(6));
    }
}
