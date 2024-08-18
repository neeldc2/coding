package heaps;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<Integer> linkedList = new LinkedList<>();
        addToQueue(linkedList);
        System.out.println(linkedList);
        print(linkedList);

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        addToQueue(priorityQueue);
        System.out.println(priorityQueue);
        print(priorityQueue);

        Queue<Integer> priorityQueueReversed = new PriorityQueue<>(Collections.reverseOrder());
        addToQueue(priorityQueueReversed);
        System.out.println(priorityQueueReversed);
        print(priorityQueueReversed);
    }

    private static void addToQueue(Queue<Integer> queue) {
        queue.add(5);
        queue.add(2);
        queue.offer(3);
    }

    private static void print(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
