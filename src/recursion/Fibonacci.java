package recursion;

import java.time.Instant;

public class Fibonacci {

    public static Long find(int n) {
        if (n == 1) {
            return 0L;
        } else if (n == 2) {
            return 1L;
        }

        return find(n - 1) + find(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(find(1));
        System.out.println(find(2));
        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
        System.out.println(find(6));
        System.out.println(find(49));
        System.out.println(Instant.now().getEpochSecond());
    }
}
