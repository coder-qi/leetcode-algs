/**
 * 1043. 分隔数组以得到最大和：https://leetcode.cn/problems/partition-array-for-maximum-sum
 */
public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] memo = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(arr, n - 1, 0, 0, k, memo);
    }

    private int dfs(int[] arr, int i, int len, int max, int k, int[][] memo) {
        if (i < 0) {
            return len * max;
        }
        if (memo[i][len] != -1) {
            return memo[i][len];
        }
        int sum = len * max + dfs(arr, i - 1, 1, arr[i], k, memo);
        if (len < k) {
            sum = Math.max(sum, dfs(arr, i - 1, len + 1, Math.max(arr[i], max), k, memo));
        }
        memo[i][len] = sum;
        return sum;
    }

    public int maxSumAfterPartitioning2(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i, max = 0; j >= 0 && (i - j) < k; j--) {
                max = Math.max(max, arr[j]);
                f[i + 1] = Math.max(f[i + 1], (i - j + 1) * max + f[j]);
            }
        }
        return f[n];
    }

}
