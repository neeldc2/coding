package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Link: https://leetcode.com/problems/number-of-islands/description/
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                if (!visited[i][j]) {
                    numberOfIslands++;
                    visited[i][j] = true;

                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.remove();

                        //going right
                        Pair pairForRight = new Pair(pair.x(), pair.y() + 1);
                        if (validPair(pairForRight, grid) && grid[pairForRight.x()][pairForRight.y()] == '1' && !visited[pairForRight.x()][pairForRight.y()]) {
                            visited[pairForRight.x()][pairForRight.y()] = true;
                            queue.add(pairForRight);
                        }

                        // going down
                        Pair pairForDown = new Pair(pair.x() + 1, pair.y());
                        if (validPair(pairForDown, grid) && grid[pairForDown.x()][pairForDown.y()] == '1' && !visited[pairForDown.x()][pairForDown.y()]) {
                            visited[pairForDown.x()][pairForDown.y()] = true;
                            queue.add(pairForDown);
                        }

                        // going left
                        Pair pairForLeft = new Pair(pair.x(), pair.y() - 1);
                        if (validPair(pairForLeft, grid) && grid[pairForLeft.x()][pairForLeft.y()] == '1' && !visited[pairForLeft.x()][pairForLeft.y()]) {
                            visited[pairForLeft.x()][pairForLeft.y()] = true;
                            queue.add(pairForLeft);
                        }

                        // going up
                        Pair pairForUp = new Pair(pair.x() - 1, pair.y());
                        if (validPair(pairForUp, grid) && grid[pairForUp.x()][pairForUp.y()] == '1' && !visited[pairForUp.x()][pairForUp.y()]) {
                            visited[pairForUp.x()][pairForUp.y()] = true;
                            queue.add(pairForUp);
                        }
                    }
                }
            }
        }

        return numberOfIslands;
    }

    private boolean validPair(Pair pair, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (pair.x() < m && pair.y() < n && pair.x() >= 0 && pair.y() >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumberOfIslands number = new NumberOfIslands();
        char[][] input = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(number.numIslands(input));
        input = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(number.numIslands(input));
        // Example that needs UP scenario
        input = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
        System.out.println(number.numIslands(input));
    }
}

record Pair(Integer x, Integer y) {
}
