import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 1289. 下降路径最小和 II：https://leetcode.cn/problems/minimum-falling-path-sum-ii
 */
public class MinimumFallingPathSumII {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dfs(grid, 0, j, memo));
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        int n = grid.length;
        if (i == n) {
            return 0;
        }
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            if (col != j) {
                min = Math.min(min, dfs(grid, i + 1, col, memo));
            }
        }
        return memo[i][j] = min + grid[i][j];
    }

    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        int[][] f = new int[n][n];
        System.arraycopy(grid[0], 0, f[0], 0, n);
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tm.put(f[i - 1][j], tm.getOrDefault(f[i - 1][j], 0) + 1);
            }
            for (int j = 0; j < n; j++) {
                int cnt = tm.get(f[i - 1][j]);
                if (cnt == 1) {
                    tm.remove(f[i - 1][j]);
                } else {
                    tm.put(f[i - 1][j], cnt - 1);
                }
                f[i][j] = tm.firstKey() + grid[i][j];
                tm.put(f[i - 1][j], tm.getOrDefault(f[i - 1][j], 0) + 1);
            }
            tm.clear();
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f[n - 1][j]);
        }
        return ans;
    }

    public int minFallingPathSum3(int[][] grid) {
        int n = grid.length;
        int[] f0 = new int[n];
        int[] f1 = new int[n];
        System.arraycopy(grid[0], 0, f0, 0, n);
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(f0[j]);
            }
            for (int j = 0; j < n; j++) {
                if (pq.peek() == f0[j]) {
                    pq.poll();
                }
                f1[j] = pq.peek() + grid[i][j];
                pq.offer(f0[j]);
            }
            int[] t = f0;
            f0 = f1;
            f1 = t;
            pq.clear();
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f0[j]);
        }
        return ans;
    }

    public int minFallingPathSum4(int[][] grid) {
        int n = grid.length;
        int min1 = 0, min2 = 0;
        int[] f0 = new int[n];
        int[] f1 = new int[n];
        for (int[] rows : grid) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                f1[j] = rows[j] + (f0[j] == min1 ? min2 : min1);
                if (f1[j] < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = f1[j];
                } else if (f1[j] < newMin2) {
                    newMin2 = f1[j];
                }
            }
            min1 = newMin1;
            min2 = newMin2;
            int[] t = f0;
            f0 = f1;
            f1 = t;
        }
        return Math.min(min1, min2);
    }

    public int minFallingPathSum5(int[][] grid) {
        int n = grid.length;
        int min1 = 0, min2 = 0;
        int min1Index = 0;
        for (int[] rows : grid) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            int newMin1Index = 0;
            for (int j = 0; j < n; j++) {
                int res = rows[j] + (j == min1Index ? min2 : min1);
                if (res < newMin1) {
                    newMin1Index = j;
                    newMin2 = newMin1;
                    newMin1 = res;
                } else if (res < newMin2) {
                    newMin2 = res;
                }
            }
            min1 = newMin1;
            min2 = newMin2;
            min1Index = newMin1Index;
        }
        return Math.min(min1, min2);
    }

}
