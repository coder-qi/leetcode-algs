import java.util.Arrays;

/**
 * 不同路径：https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (n > m) {
            return uniquePaths(n, m);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(23, 12)); // 193536720
        System.out.println(uniquePaths(1, 1)); // 1
        System.out.println(uniquePaths(1, 2)); // 1
    }

}
