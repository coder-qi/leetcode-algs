import util.ArrayUtils;

import java.util.*;

/**
 * 1463. 摘樱桃 II：https://leetcode.cn/problems/cherry-pickup-ii/
 */
public class CherryPickupII {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][n];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return dfs(grid, 0, 0, n - 1, memo);
    }

    private int dfs(int[][] grid, int i, int j1, int j2, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m || j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return 0;
        }
        if (memo[i][j1][j2] != -1) {
            return memo[i][j1][j2];
        }
        int best = 0;
        for (int k1 = -1; k1 <= 1; k1++) {
            int nj1 = j1 + k1;
            for (int k2 = -1; k2 <= 1; k2++) {
                int nj2 = j2 + k2;
                best = Math.max(best, dfs(grid, i + 1, nj1, nj2, memo));
            }
        }
        return memo[i][j1][j2] = best + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
    }

    public int cherryPickup2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 2][n + 2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j1 = n - 1; j1 >= 0; j1--) {
                for (int j2 = n - 1; j2 >= 0 ; j2--) {
                    int best = 0;
                    for (int k1 = -1; k1 <= 1; k1++) {
                        int nj1 = j1 + k1;
                        for (int k2 = -1; k2 <= 1; k2++) {
                            int nj2 = j2 + k2;
                            best = Math.max(best, f[i + 1][nj1 + 1][nj2 + 1]);
                        }
                    }
                    f[i][j1 + 1][j2 + 1] = best + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                }
            }
        }
        return f[0][1][n];
    }

    public int cherryPickup3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f1 = new int[n + 2][n + 2];
        int[][] f2 = new int[n + 2][n + 2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j1 = n - 1; j1 >= 0; j1--) {
                for (int j2 = n - 1; j2 >= 0 ; j2--) {
                    int best = 0;
                    for (int k1 = -1; k1 <= 1; k1++) {
                        int nj1 = j1 + k1;
                        for (int k2 = -1; k2 <= 1; k2++) {
                            int nj2 = j2 + k2;
                            best = Math.max(best, f1[nj1 + 1][nj2 + 1]);
                        }
                    }
                    f2[j1 + 1][j2 + 1] = best + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                }
            }
            int[][] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        return f1[1][n];
    }

    public int cherryPickup4(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f1 = new int[n + 2][n + 2];
        int[][] f2 = new int[n + 2][n + 2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j1 = n - 1; j1 >= 0; j1--) {
                for (int j2 = n - 1; j2 >= 0; j2--) {
                    int best = f1[j1][j2];
                    best = Math.max(best, f1[j1][j2 + 1]);
                    best = Math.max(best, f1[j1][j2 + 2]);

                    best = Math.max(best, f1[j1 + 1][j2]);
                    best = Math.max(best, f1[j1 + 1][j2 + 1]);
                    best = Math.max(best, f1[j1 + 1][j2 + 2]);

                    best = Math.max(best, f1[j1 + 2][j2]);
                    best = Math.max(best, f1[j1 + 2][j2 + 1]);
                    best = Math.max(best, f1[j1 + 2][j2 + 2]);
                    f2[j1 + 1][j2 + 1] = best + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                }
            }
            int[][] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        return f1[1][n];
    }

    public int cherryPickup5(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f1 = new int[n + 2][n + 2];
        int[][] f2 = new int[n + 2][n + 2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j1 = Math.min(n - 1, i); j1 >= 0; j1--) {
                for (int j2 = n - 1; j2 >= j1; j2--) {
                    int best = f1[j1][j2];
                    best = Math.max(best, f1[j1][j2 + 1]);
                    best = Math.max(best, f1[j1][j2 + 2]);

                    best = Math.max(best, f1[j1 + 1][j2]);
                    best = Math.max(best, f1[j1 + 1][j2 + 1]);
                    best = Math.max(best, f1[j1 + 1][j2 + 2]);

                    best = Math.max(best, f1[j1 + 2][j2]);
                    best = Math.max(best, f1[j1 + 2][j2 + 1]);
                    best = Math.max(best, f1[j1 + 2][j2 + 2]);
                    f2[j1 + 1][j2 + 1] = best + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                }
            }
            int[][] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        return f1[1][n];
    }

    public static void main(String[] args) {
        CherryPickupII app = new CherryPickupII();
        System.out.println(app.cherryPickup5(ArrayUtils.matrix("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]")));
    }

}
