package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

// This makes push operation expensive. But, pop and top operation are efficient.
// I would prefer this over the other method that makes push efficient because
// 1. Only 1 method is expensive here. In the other approach, 2 methods are expensive.
// 2. Code is also much simpler in this approach.
public class StackUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty());  // Output: false
    }
}
