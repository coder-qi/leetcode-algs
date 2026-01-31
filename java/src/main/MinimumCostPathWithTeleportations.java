import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3651. 带传送的最小路径成本：https://leetcode.cn/problems/minimum-cost-path-with-teleportations
 */
public class MinimumCostPathWithTeleportations {

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] a = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i * n + j][0] = grid[i][j];
                a[i * n + j][1] = i;
                a[i * n + j][2] = j;
            }
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        int[][][] memo = new int[m][n][k + 1];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return dfs(grid, a, 0, 0, k, memo);
    }

    private int dfs(int[][] grid, int[][] a, int i, int j, int k, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (k < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (i == m - 1 && j == n - 1) {
            return 0;
        }

        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        int res = Integer.MAX_VALUE / 2;
        for (int r = lowerbound(a, grid[i][j]) - 1; r >= 0; r--) {
            res = Math.min(res, dfs(grid, a, a[r][1], a[r][2], k - 1, memo));
        }
        if (i + 1 < m) {
            res = Math.min(res, dfs(grid, a, i + 1, j, k, memo) + grid[i + 1][j]);
        }
        if (j + 1 < n) {
            res = Math.min(res, dfs(grid, a, i, j + 1, k, memo) + grid[i][j + 1]);
        }
        return memo[i][j][k] = res;
    }
    private int lowerbound(int[][] a, int target) {
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int minCost2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] a = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i * n + j][0] = grid[i][j];
                a[i * n + j][1] = i;
                a[i * n + j][2] = j;
            }
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        int[][][] f = new int[m + 1][n + 1][k + 1];
        for (int[][] row : f) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE / 2);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int x = 0; x <= k; x++) {
                    int res = i == m - 1 && j == n - 1 ? 0 : Integer.MAX_VALUE / 2;
                    if (i + 1 < m) {
                        res = Math.min(res, f[i + 1][j][x] + grid[i + 1][j]);
                    }
                    if (j + 1 < n) {
                        res = Math.min(res, f[i][j + 1][x] + grid[i][j + 1]);
                    }
                    if (x > 0) {
                        for (int r = lowerbound(a, grid[i][j]) - 1; r >= 0; r--) {
                            res = Math.min(res, f[a[r][1]][a[r][2]][x - 1]);
                        }
                    }
                    f[i][j][x] = res;
                }
            }
        }
        return f[0][0][k];
    }

    public int minCost3(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        int[][][] f = new int[m + 1][n + 1][k + 1];
        int INF = Integer.MAX_VALUE / 2;
        for (int[][] row : f) {
            for (int[] col : row) {
                Arrays.fill(col, INF);
            }
        }

        // 超时的原因是因为每次都枚举小于grid[i][j]的格子的最小成本，时间复杂度：O(k(mn)^2 * log(mn))
        int[] preMin1 = new int[max + 1];
        int[] preMin2 = new int[max + 1];
        Arrays.fill(preMin1, INF);
        for (int x = 0; x <= k; x++) {
            Arrays.fill(preMin2, INF);
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int res = i == m - 1 && j == n - 1 ? 0 : INF;
                    if (i + 1 < m) {
                        res = Math.min(res, f[i + 1][j][x] + grid[i + 1][j]);
                    }
                    if (j + 1 < n) {
                        res = Math.min(res, f[i][j + 1][x] + grid[i][j + 1]);
                    }
                    if (x > 0) {
                        res = Math.min(res, preMin1[grid[i][j]]);
                    }
                    f[i][j][x] = res;
                    preMin2[grid[i][j]] = Math.min(preMin2[grid[i][j]], res);
                }
            }
            for (int i = 1; i <= max; i++) {
                preMin2[i] = Math.min(preMin2[i], preMin2[i - 1]);
            }
            int[] t = preMin1;
            preMin1 = preMin2;
            preMin2 = t;
        }
        return f[0][0][k];
    }

    public int minCost4(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        int[] f = new int[n + 1];

        // 超时的原因是因为每次都枚举小于grid[i][j]的格子的最小成本，时间复杂度：O(k(mn)^2 * log(mn))
        int[] preMin1 = new int[max + 1];
        int[] preMin2 = new int[max + 1];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(preMin1, INF);
        for (int x = 0; x <= k; x++) {
            Arrays.fill(preMin2, INF);
            Arrays.fill(f, INF);
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int res = i == m - 1 && j == n - 1 ? 0 : INF;
                    if (i + 1 < m) {
                        res = Math.min(res, f[j] + grid[i + 1][j]);
                    }
                    if (j + 1 < n) {
                        res = Math.min(res, f[j + 1] + grid[i][j + 1]);
                    }
                    if (x > 0) {
                        res = Math.min(res, preMin1[grid[i][j]]);
                    }
                    f[j] = res;
                    preMin2[grid[i][j]] = Math.min(preMin2[grid[i][j]], res);
                }
            }
            for (int i = 1; i <= max; i++) {
                preMin2[i] = Math.min(preMin2[i], preMin2[i - 1]);
            }
            int[] t = preMin1;
            preMin1 = preMin2;
            preMin2 = t;
        }
        return f[0];
    }

    public static void main(String[] args) {
        MinimumCostPathWithTeleportations app = new MinimumCostPathWithTeleportations();
        System.out.println(app.minCost4(ArrayUtils.matrix("[[1,3,3],[2,5,4],[4,3,5]]"), 2));
        System.out.println(app.minCost4(ArrayUtils.matrix("[[1,2],[2,3],[3,4]]"), 1));
    }

}
