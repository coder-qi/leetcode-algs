/**
 * 1895. 最大的幻方：https://leetcode.cn/problems/largest-magic-square
 */
public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int len = 2; len <= Math.min(m - i, n - j); len++) {
                    if (isMagicSquare(grid, i, j, len)) {
                        ans = Math.max(ans, len);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int row, int column, int len) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum += grid[row + i][column + i];
            sum2 += grid[row + i][column + len - i - 1];
        }
        if (sum != sum2) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < len; j++) {
                rowSum += grid[row + i][column + j];
                columnSum += grid[row + j][column + i];
            }
            if (rowSum != sum || columnSum != sum) {
                return false;
            }
        }
        return true;
    }

    public int largestMagicSquare2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] preRowSum = new int[m][n + 1];
        int[][] preColumnSum = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preRowSum[i][j + 1] = preRowSum[i][j] + grid[i][j];
                preColumnSum[i + 1][j] = preColumnSum[i][j] + grid[i][j];
            }
        }
        for (int len = Math.min(m, n); len >= 2; len--) {
            for (int i = 0; i + len <= m; i++) {
                for (int j = 0; j + len <= n; j++) {
                    if (isMagicSquare2(grid, preRowSum, preColumnSum, i, j, len)) {
                        return len;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagicSquare2(int[][] grid, int[][] preRowSum, int[][] preColumnSum, int row, int column, int len) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum += grid[row + i][column + i];
            sum2 += grid[row + i][column + len - i - 1];
        }
        if (sum != sum2) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            int rowSum = preRowSum[row + i][column + len] - preRowSum[row + i][column];
            int columnSum = preColumnSum[row + len][column + i] - preColumnSum[row][column + i];
            if (rowSum != sum || columnSum != sum) {
                return false;
            }
        }
        return true;
    }

}
