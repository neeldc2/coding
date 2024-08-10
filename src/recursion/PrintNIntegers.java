package recursion;

public class PrintNIntegers {

    int maxNumber;

    private void print(int n) {
        maxNumber = n;
        printFromOne(1);
        printFromN(1);
    }

    private void printFromOne(int i) {
        if (i > maxNumber) {
            return;
        }

        System.out.println(i);
        // This is done differently in the method printFromN()
        // Instead of doing i++, it does (i + 1)
        i++;
        printFromOne(i);
    }

    private void printFromN(int i) {
        if (i > maxNumber) {
            return;
        }

        printFromN(i + 1);
        System.out.println(i);
    }

    public static void main(String[] args) {
        PrintNIntegers printNIntegers = new PrintNIntegers();
        printNIntegers.print(10);
    }
}
