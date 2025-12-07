/**
 * 3196. 最大化子数组的总成本：https://leetcode.cn/problems/maximize-total-cost-of-alternating-subarrays
 */
public class MaximizeTotalCostOfAlternatingSubarrays {

    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i], nums[i - 1] - nums[i] + dp[i - 1]);
        }
        return dp[n];
    }

}
