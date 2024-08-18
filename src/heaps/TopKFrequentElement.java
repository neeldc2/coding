package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue((a, b) -> map.get(b) - map.get(a));

        for (int num : map.keySet()) {
            queue.offer(num);
        }

        int[] solution = new int[k];
        for (int i = 0 ; i < k ; i++) {
            solution[i] = queue.poll();
        }

        return solution;
    }

    public static void main(String[] args) {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        print(topKFrequentElement.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));;
    }

    private static void print(int[] ints) {
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
