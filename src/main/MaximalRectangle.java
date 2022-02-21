/**
 * 最大矩形：https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        if (matrix[0][0] == '1') {
            dp[0][0] = 1;
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = dp[i - 1][0] + 1;
                ans = Math.max(ans, dp[i][0]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = dp[0][i - 1] + 1;
                ans = Math.max(ans, dp[0][i]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //dp[i][j] = dp[0][i - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

}
