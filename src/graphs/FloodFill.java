package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Link: https://leetcode.com/problems/flood-fill/description/
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 * <p>
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * <p>
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int colourOfSelectedPixel = image[sr][sc];

        if (colourOfSelectedPixel == color) {
            return image;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            Pair abovePair = new Pair(pair.x() - 1, pair.y());
            Pair belowPair = new Pair(pair.x() + 1, pair.y());
            Pair leftPair = new Pair(pair.x(), pair.y() - 1);
            Pair rightPair = new Pair(pair.x(), pair.y() + 1);

            if (validPair(abovePair, image) && image[abovePair.x()][abovePair.y()] == colourOfSelectedPixel) {
                queue.offer(abovePair);
                image[abovePair.x()][abovePair.y()] = color;
            }
            if (validPair(belowPair, image) && image[belowPair.x()][belowPair.y()] == colourOfSelectedPixel) {
                queue.offer(belowPair);
                image[belowPair.x()][belowPair.y()] = color;
            }
            if (validPair(leftPair, image) && image[leftPair.x()][leftPair.y()] == colourOfSelectedPixel) {
                queue.offer(leftPair);
                image[leftPair.x()][leftPair.y()] = color;
            }
            if (validPair(rightPair, image) && image[rightPair.x()][rightPair.y()] == colourOfSelectedPixel) {
                queue.offer(rightPair);
                image[rightPair.x()][rightPair.y()] = color;
            }
        }

        return image;
    }

    private boolean validPair(Pair pair, int[][] image) {
        int m = image.length;
        int n = image[0].length;

        if (pair.x() < m && pair.y() < n && pair.x() >= 0 && pair.y() >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] input = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        print2DArray(floodFill.floodFill(input, 1, 1, 2));
    }

    private static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
