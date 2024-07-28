package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
    private Queue<Integer> queue;

    public StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.remove();
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty());  // Output: false
    }
}
