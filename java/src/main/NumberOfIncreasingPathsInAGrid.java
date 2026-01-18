import java.util.Arrays;

/**
 * 2328. 网格图中递增路径的数目：https://leetcode.cn/problems/number-of-increasing-paths-in-a-grid
 */
public class NumberOfIncreasingPathsInAGrid {

    final int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int mod = (int) (1e9 + 7);

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, i, j, memo)) % mod;
            }
        }
        return (int) ans;
    }

    private int dfs(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        long cnt = 1;
        for (int[] direct : directs) {
            int nextRow = i + direct[0];
            int nextCol = j + direct[1];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > grid[i][j]) {
                cnt += dfs(grid, nextRow, nextCol, memo);
            }
        }
        return memo[i][j] = (int) (cnt % mod);
    }

}
