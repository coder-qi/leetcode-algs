/**
 * 1351. 统计有序矩阵中的负数：https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix
 */
public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0, j = 0; i < m; i++) {
            for (;j < n; j++) {
                if (grid[i][j] < 0) {
                    ans += n - j;
                    break;
                }
            }
        }
        return ans;
    }

    public int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = m - 1, j = 0; i >= 0; i--) {
            for (;j < n; j++) {
                if (grid[i][j] < 0) {
                    ans += n - j;
                    break;
                }
            }
        }
        return ans;
    }

}
