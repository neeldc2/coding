package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Link: https://leetcode.com/problems/number-of-provinces/
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * <p>
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * <p>
 * Example 2:
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int cityCount = isConnected.length;
        boolean[] visited = new boolean[cityCount];

        for (int i = 0; i < cityCount; i++) {
            if (!visited[i]) {
                provinces++;
                visited[i] = true;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            // find all indirectly connected cities
            while (!queue.isEmpty()) {
                int fromCity = queue.remove();
                for (int toCity = 0; toCity < cityCount; toCity++) {
                    if (fromCity == toCity) {
                        continue;
                    }
                    if (isConnected[fromCity][toCity] == 1 && !visited[toCity]) {
                        visited[toCity] = true;
                        queue.offer(toCity);
                    }
                }
            }

        }

        return provinces;
    }

    public static void main(String[] args) {
        NumberOfProvinces number = new NumberOfProvinces();
        System.out.println(number.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        ;
        System.out.println(number.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        ;
    }
}
