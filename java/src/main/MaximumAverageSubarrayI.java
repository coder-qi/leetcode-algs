/**
 * 643. 子数组最大平均数 I：https://leetcode.cn/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }

}
