package stackandqueue;

public class Stack {
    private int[] stackArray;
    private int stackSize;
    private int top;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new int[stackSize];
        top = -1;
    }

    public void push(int element) {
        if (top + 1 == stackSize) {
            System.out.println("Cannot add to the stack");
            return;
        }
        top++;
        stackArray[top] = element;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Nothing in the stack");
            return -1;
        }

        int element = stackArray[top];
        top--;
        return element;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Nothing in the stack to peek");
            return -1;
        }

        return stackArray[top];
    }

    // Got this from Derek Banas YoutTube video
    public void displayTheStack(){
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackSize; n++){
            System.out.format("| %2s "+ " ", n);
        }

        System.out.println("|");

        for(int n = 0; n < 61; n++) {
            System.out.print("-");
        }
        System.out.println();

        for(int n = 0; n < stackSize; n++){
            if(stackArray[n] == -1) {
                System.out.print("|     ");
            }

            else {
                System.out.print(String.format("| %2s "+ " ", stackArray[n]));
            }

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.displayTheStack();
    }
}
