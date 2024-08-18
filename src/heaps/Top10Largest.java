package heaps;

import java.util.PriorityQueue;

public class Top10Largest {

    private PriorityQueue<Integer> minHeap;

    public Top10Largest() {
        // Min-heap to store the top 10 largest numbers
        minHeap = new PriorityQueue<>(10);
    }

    public void addNumber(int num) {
        if (minHeap.size() < 10) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    public int[] getTop10() {
        return minHeap.stream().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Top10Largest top10 = new Top10Largest();
        //int[] numbers = {5, 20, 15, 3, 8, 25, 7, 18, 9, 2, 11, 30};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (int num : numbers) {
            top10.addNumber(num);
        }

        int[] result = top10.getTop10();
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
