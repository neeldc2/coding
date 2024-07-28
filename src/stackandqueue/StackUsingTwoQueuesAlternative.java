package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

// This makes pop and top operation expensive. Push operation is efficient.
public class StackUsingTwoQueuesAlternative {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingTwoQueuesAlternative() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int result = queue1.remove();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int result = queue1.peek();
        queue2.add(queue1.remove());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueuesAlternative stack = new StackUsingTwoQueuesAlternative();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty());  // Output: false
    }
}