/**
 * 最小路径和：https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = (j - 1 >= 0 ? dp[j - 1] : 0) + grid[i][j];
                } else {
                    dp[j] = grid[i][j] + (j - 1 >= 0 ? Math.min(dp[j], dp[j - 1]) : dp[j]);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
            {1,3,1},{1,5,1},{4,2,1}
        })); // 7
        System.out.println(minPathSum(new int[][]{
            {1,2,3},{4,5,6}
        })); // 12
    }

}
