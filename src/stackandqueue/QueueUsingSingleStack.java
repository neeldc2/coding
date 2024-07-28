package stackandqueue;

import java.util.Stack;

public class QueueUsingSingleStack {
    private Stack<Integer> stack;

    public QueueUsingSingleStack() {
        stack = new Stack<>();
    }

    public void enqueue(int x) {
        stack.push(x);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        int item = stack.pop();
        int result = dequeue();
        stack.push(item);
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack.size() == 1) {
            return stack.peek();
        }
        int item = stack.pop();
        int result = peek();
        stack.push(item);
        return result;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingSingleStack queue = new QueueUsingSingleStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());  // Output: 1
        queue.enqueue(4);
        System.out.println(queue.dequeue());  // Output: 2
        System.out.println(queue.dequeue());  // Output: 3
        System.out.println(queue.dequeue());  // Output: 4
        System.out.println(queue.isEmpty());  // Output: true
    }
}
