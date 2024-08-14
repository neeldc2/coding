package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n == 1) {
            solutions.add(List.of("Q"));
            return solutions;
        }
        if (n < 4) {
            return new ArrayList<>();
        }

        String[][] solution = new String[n][n];
        solve(n, solution, 0, solutions);
        return solutions;
    }

    private void solve(int n, String[][] solution, int i, List<List<String>> solutions) {
        if (i == n) {
            convert(solution, solutions, n);
            return;
        }

        String[] row = solution[i];
        for (int k = 0 ; k < n ; k++) {
            if (row[k] == null || "".equals(row[k])) {
                row[k] = "Q";
                List<IndexPair> indexesModified = new ArrayList<>();
                populate(solution, i, k, n, indexesModified);
                solve(n, solution, i + 1, solutions);
                revert(solution, indexesModified);
                row[k] = null;
            }
        }
    }

    private void revert(String[][] solution, List<IndexPair> indexesModified) {
        for (IndexPair index : indexesModified) {
            solution[index.indexA()][index.indexB()] = null;
        }
    }

    private void populate(String[][] solution, int i, int k, int n, List<IndexPair> indexesModified) {
        for (int x = 0 ; x < n ; x++) {
            if (x != k) {
                if (!".".equals(solution[i][x])) {
                    indexesModified.add(new IndexPair(i, x));
                    solution[i][x] = ".";
                }
            }
        }
        for (int x = 0 ; x < n ; x++) {
            if (x != i) {
                if (!".".equals(solution[x][k])) {
                    indexesModified.add(new IndexPair(x, k));
                    solution[x][k] = ".";
                }
            }
        }

        for (int x = i + 1, y = k + 1; x < n && y < n ; x++ , y++) {
            if (!".".equals(solution[x][y])) {
                indexesModified.add(new IndexPair(x, y));
                solution[x][y] = ".";
            }
        }

        for (int x = i + 1, y = k - 1; x < n && y >= 0 ; x++ , y--) {
            if (!".".equals(solution[x][y])) {
                indexesModified.add(new IndexPair(x, y));
                solution[x][y] = ".";
            }
        }
    }

    private void convert(String[][] solution, List<List<String>> solutions, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s = s + solution[i][j];
            }
            temp.add(s);
        }
        solutions.add(temp);
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> solution = nQueens.solveNQueens(4);
        System.out.println(solution);
    }

}

record IndexPair(int indexA, int indexB) {

}