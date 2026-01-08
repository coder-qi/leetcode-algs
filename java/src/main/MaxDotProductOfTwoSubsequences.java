import java.util.Arrays;

/**
 * 1458. 两个子序列的最大点积：https://leetcode.cn/problems/max-dot-product-of-two-subsequences
 */
public class MaxDotProductOfTwoSubsequences {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums1, nums2, m - 1, n - 1, memo);
    }

    private int dfs(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        int res1 = nums1[i] * nums2[j] + Math.max(dfs(nums1, nums2, i - 1, j - 1, memo), 0);
        int res2 = dfs(nums1, nums2, i - 1, j, memo);
        int res3 = dfs(nums1, nums2, i, j - 1, memo);
        return memo[i][j] = Math.max(res1, Math.max(res2, res3));
    }

    public int maxDotProduct2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = Integer.MIN_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = Math.max(nums1[i] * nums2[j] + Math.max(f[i][j], 0), Math.max(f[i][j + 1], f[i + 1][j]));
            }
        }
        return f[m][n];
    }

    public int maxDotProduct3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        for (int x : nums1) {
            int prev = f[0];
            for (int j = 0; j < n; j++) {
                int tmp = f[j + 1];
                f[j + 1] = Math.max(x * nums2[j] + Math.max(prev, 0), Math.max(f[j + 1], f[j]));
                prev = tmp;
            }
        }
        return f[n];
    }

}
