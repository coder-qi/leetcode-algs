/**
 * 840. 矩阵中的幻方：https://leetcode.cn/problems/magic-squares-in-grid
 */
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        int cross1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int cross2 = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        if (cross1 != cross2) {
            return false;
        }
        int[] count = new int[10];
        for (int row = i; row < i + 3; row++) {
            int s = 0;
            for (int col = j; col < j + 3; col++) {
                if (grid[row][col] <= 0 || grid[row][col] > 9) {
                    return false;
                }
                if (++count[grid[row][col]] > 1) {
                    return false;
                };
                s += grid[row][col];
            }
            if (s != cross1) {
                return false;
            }
        }
        for (int col = j; col < j + 3; col++) {
            int s = 0;
            for (int row = i; row < i + 3; row++) {
                s += grid[row][col];
            }
            if (s != cross1) {
                return false;
            }
        }
        return true;
    }

}
