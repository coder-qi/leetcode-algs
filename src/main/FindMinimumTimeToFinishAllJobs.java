/**
 * 1723. 完成所有工作的最短时间：https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/
 */
public class FindMinimumTimeToFinishAllJobs {

    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[] {3,2,3}, 3));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
            sum[i] = sum[y] + jobs[x];
        }
        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int min = Integer.MAX_VALUE;
                for (int x = j; x != 0; x = (x - 1) & j) {
                    min = Math.min(min, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }

}
