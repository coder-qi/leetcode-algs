import util.ArrayUtils;

/**
 * 3393. 统计异或值为给定值的路径数目：https://leetcode.cn/problems/count-paths-with-the-given-xor-value
 */
public class CountPathsWithTheGivenXorValue {

    int mod = 1000000007;

    // 记忆化搜索
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][16];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < 16; l++) {
                    memo[i][j][l] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, 0, k, memo);
    }

    private int dfs(int[][] grid, int i, int j, int xor, int k, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return (grid[i][j] ^ xor) == k ? 1 : 0;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j][xor] != -1) {
            return memo[i][j][xor];
        }
        return memo[i][j][xor] = (dfs(grid, i, j + 1, grid[i][j] ^ xor, k, memo) + dfs(grid, i + 1, j, grid[i][j] ^ xor, k, memo)) % mod;
    }

    // dp
    public int countPathsWithXorValue2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 1][16];
        for (int x = 0; x < 16; x++) {
            if ((grid[m - 1][n - 1] ^ x) == k) {
                f[m][n - 1][x ^ grid[m - 1][n - 1]] = 1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int x = 0; x < 16; x++) {
                    f[i][j][x] = (f[i][j + 1][grid[i][j] ^ x] + f[i + 1][j][grid[i][j] ^ x]) % mod;
                }
            }
        }
        return f[0][0][0];
    }

    public int countPathsWithXorValue3(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int max = k;
        for (int[] row : grid) {
            for (int x : row) {
                if (x > max) {
                    max = x;
                }
            }
        }
        int u = 1 << (32 - Integer.numberOfLeadingZeros(max));
        if (k >= u) {
            return 0;
        }
        int[][][] f = new int[2][n + 1][u + 1];
        for (int x = 0; x <= u; x++) {
            if ((grid[m - 1][n - 1] ^ x) == k) {
                f[m % 2][n - 1][x ^ grid[m - 1][n - 1]] = 1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int x = 0; x < u; x++) {
                    f[i % 2][j][x] = (f[i % 2][j + 1][grid[i][j] ^ x] + f[(i + 1) % 2][j][grid[i][j] ^ x]) % mod;
                }
            }
        }
        return f[0][0][0];
    }

    public static void main(String[] args) {
        CountPathsWithTheGivenXorValue app = new CountPathsWithTheGivenXorValue();
        System.out.println(app.countPathsWithXorValue3(ArrayUtils.matrix("[[2, 1, 5], [7, 10, 0], [12, 6, 4]]"), 11));
    }

}
