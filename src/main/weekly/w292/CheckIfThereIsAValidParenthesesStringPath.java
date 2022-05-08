package weekly.w292;

/**
 * 6059. 检查是否有合法括号字符串路径：https://leetcode-cn.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 */
public class CheckIfThereIsAValidParenthesesStringPath {

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = grid[i][j] == '(' ? 1 : -1;
                } else {
                    if (grid[i][j] == '(') {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) - 1;
                    }
                }
            }
        }
        return dp[m - 1][n - 1] == 0;
    }

    public static void main(String[] args) {

    }

}
