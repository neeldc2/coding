package stackandqueue;

public class Queue {

    private int[] queueArray;
    private int queueSize;
    private int front;
    private int rear;

    public Queue(int queueSize) {
        this.queueSize = queueSize;
        queueArray = new int[queueSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int element) {
        if (rear + 1 == queueSize) {
            System.out.println("Cannot add to the queue");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        queueArray[rear] = element;
    }

    public int dequeue() {
        int element = queueArray[front];
        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return element;
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Nothing in the stack to peek");
            return -1;
        }

        return queueArray[front];
    }

    // Got this from Derek Banas YoutTube video
    public void displayTheQueue() {
        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < queueSize; n++) {
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < queueSize; n++) {
            if (queueArray[n] == -1) {
                System.out.print("|     ");
            } else {
                System.out.print(String.format("| %2s " + " ", queueArray[n]));
            }

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }

        System.out.println();

        // Number of spaces to put before the F
        int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

        for (int k = 1; k < spacesBeforeFront; k++) {
            System.out.print(" ");
        }

        System.out.print("F");

        // Number of spaces to put before the R
        int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

        for (int l = 0; l < spacesBeforeRear; l++) {
            System.out.print(" ");
        }

        System.out.print("R");
        System.out.println("\n");
    }

}
