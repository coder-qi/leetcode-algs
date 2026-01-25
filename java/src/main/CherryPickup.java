import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 741. 摘樱桃：https://leetcode.cn/problems/cherry-pickup/
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] memo = new int[n * 2][n][n];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }
        return Math.max(dfs(grid, 0, 0, 0, memo), 0);
    }


    private int dfs(int[][] grid, int t, int i1, int i2, int[][][] memo) {
        int n = grid.length;
        int j1 = t - i1;
        int j2 = t - i2;
        if (i1 >= n || i2 >= n || j1 >= n || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (i1 == n - 1 && j1 == n - 1 && i2 == n - 1 && j2 == n - 1) {
            return grid[i1][j1];
        }
        if (memo[t][i1][i2] != Integer.MIN_VALUE) {
            return memo[t][i1][i2];
        }
        return memo[t][i1][i2] = Math.max(
                Math.max(
                        dfs(grid, t + 1, i1 + 1, i2 + 1, memo), // 下下
                        dfs(grid, t + 1, i1 + 1, i2, memo) // 下右
                ),
                Math.max(
                        dfs(grid, t + 1, i1, i2 + 1, memo), // 右下
                        dfs(grid, t + 1, i1, i2, memo) // 右右
                )
        ) + (i1 == i2 ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2]);
    }

    public int cherryPickup2(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2][n + 1][n + 1];
        for (int[][] row : f) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }
        f[n * 2 - 1][n - 1][n] = 0;
        for (int t = n * 2 - 2; t >= 0; t--) {
            for (int i1 = Math.min(t, n - 1); i1 >= Math.max(t - n + 1, 0); i1--) {
                for (int i2 = Math.min(t, n - 1); i2 >= Math.max(t - n + 1, 0); i2--) {
                    int j1 = t - i1;
                    int j2 = t - i2;
                    if (grid[i1][j1] == -1 || grid[i2][j2] == -1) {
                        continue;
                    }
                    f[t][i1][i2] = Math.max(
                            Math.max(
                                    f[t + 1][i1 + 1][i2 + 1], // 下下
                                    f[t + 1][i1 + 1][i2]// 下右
                            ),
                            Math.max(
                                    f[t + 1][i1][i2 + 1], // 右下
                                    f[t + 1][i1][i2] // 右右
                            )
                    ) + (i1 == i2 ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2]);
                }
            }
        }
        return Math.max(f[0][0][0], 0);
    }

    public int cherryPickup3(int[][] grid) {
        int n = grid.length;
        int[][] f1 = new int[n + 1][n + 1];
        int[][] f2 = new int[n + 1][n + 1];
        for (int[] row : f1) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int[] row : f2) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        f1[n - 1][n - 1] = 0;
        for (int t = n * 2 - 2; t >= 0; t--) {
            for (int i1 = Math.min(t, n - 1); i1 >= Math.max(t - n + 1, 0); i1--) {
                for (int i2 = Math.min(t, n - 1); i2 >= Math.max(t - n + 1, 0); i2--) {
                    int j1 = t - i1;
                    int j2 = t - i2;
                    if (grid[i1][j1] == -1 || grid[i2][j2] == -1) {
                        f2[i1][i2] = Integer.MIN_VALUE;
                        continue;
                    }
                    f2[i1][i2] = Math.max(
                            Math.max(
                                    f1[i1 + 1][i2 + 1], // 下下
                                    f1[i1 + 1][i2]// 下右
                            ),
                            Math.max(
                                    f1[i1][i2 + 1], // 右下
                                    f1[i1][i2] // 右右
                            )
                    ) + (i1 == i2 ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2]);
                }
            }
            int[][] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        return Math.max(f1[0][0], 0);
    }

    public static void main(String[] args) {
        System.out.println(new CherryPickup().cherryPickup3(matrix("[[0, 1, -1],[1, 0, -1],[1, 1,  1]]"))); // 5
    }

}
