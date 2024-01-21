import java.util.Arrays;

/**
 * 410. 分割数组的最大值：https://leetcode.cn/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int m = 0; m < i; m++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[m][j - 1], preSum[i] - preSum[m]));
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {7,2,5,10,8}, 2)); // 18
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,2,3,4,5}, 2)); // 9
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,4,4}, 3)); // 4
    }

}
