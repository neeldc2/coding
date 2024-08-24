package heaps;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a , b) -> b - a);
        minHeap = new PriorityQueue<>((a , b) -> a - b);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (minHeap.isEmpty()) {
            int maxElementInMaxHeap = maxHeap.peek();

            if (num >= maxElementInMaxHeap) {
                minHeap.offer(num);
            } else {
                maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(maxElementInMaxHeap);
            }
        } else {
            int maxElementInMaxHeap = maxHeap.peek();
            int minElementInMinHeap = minHeap.peek();

            if (num <= maxElementInMaxHeap) {
                maxHeap.offer(num);
            } else if (num >= minElementInMinHeap) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            int sizeOfMaxHeap = maxHeap.size();
            int sizeOfMinHeap = minHeap.size();

            // Allow adding numbers to both sides of the heap
            // Balance the heap only when the size difference is 2.
            if (Math.abs(sizeOfMaxHeap - sizeOfMinHeap) > 1) {
                if (sizeOfMaxHeap > sizeOfMinHeap) {
                    maxElementInMaxHeap = maxHeap.poll();
                    minHeap.offer(maxElementInMaxHeap);
                } else {
                    minElementInMinHeap = minHeap.poll();
                    maxHeap.offer(minElementInMinHeap);
                }
            }
        }
    }

    public double findMedian() {
        int sizeOfMaxHeap = maxHeap.size();
        int sizeOfMinHeap = minHeap.size();

        // sizeOfMaxHeap == sizeOfMinHeap means it is even
        if (sizeOfMaxHeap == sizeOfMinHeap) {
            int maxElementInMaxHeap = maxHeap.peek();
            int minElementInMinHeap = minHeap.peek();

            return Double.valueOf(maxElementInMaxHeap + minElementInMinHeap) / 2;
        } else if (sizeOfMaxHeap > sizeOfMinHeap) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        medianFinder.addNum(6);
        medianFinder.addNum(5);
        medianFinder.addNum(3);
        medianFinder.addNum(8);
        medianFinder.addNum(9);
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }
}
