/**
 * 3643. 垂直翻转子矩阵：https://leetcode.cn/problems/flip-square-submatrix-vertically
 */
public class FlipSquareSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, res[i], 0, n);
        }
        for (int i = 0; i < k; i++) {
            System.arraycopy(grid[x + k - 1 - i], y, res[x + i], y, k);
        }
        return res;
    }

}
