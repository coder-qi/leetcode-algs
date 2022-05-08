import static util.ArrayUtils.matrixChar;

/**
 * 221. 最大正方形：https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(matrixChar(
            "[[\"1\",\"0\",\"1\",\"0\",\"0\"]," +
                "[\"1\",\"0\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"1\",\"1\",\"1\",\"1\"]," +
                "[\"1\",\"0\",\"0\",\"1\",\"0\"]]"))); // 4
        System.out.println(maximalSquare(matrixChar(
            "[[\"0\",\"1\"],[\"1\",\"0\"]]"))); // 1
        System.out.println(maximalSquare(matrixChar(
            "[[\"0\"]]"))); // 0
    }

}
