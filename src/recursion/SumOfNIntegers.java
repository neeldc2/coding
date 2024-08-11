package recursion;

public class SumOfNIntegers {

    private int n;

    private int sum(int n) {
        this.n = n;
        return calculate(1);
    }

    private int calculate(int i) {
        if (i == n) {
            return n;
        }
        return i + calculate(i + 1);
    }

    private int sumV2(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumV2(n-1);
    }

    public static void main(String[] args) {
        SumOfNIntegers sumOfNIntegers = new SumOfNIntegers();
        Integer sum = sumOfNIntegers.sum(4);
        System.out.println(sum);
        sum = sumOfNIntegers.sumV2(5);
        System.out.println(sum);
    }
}
