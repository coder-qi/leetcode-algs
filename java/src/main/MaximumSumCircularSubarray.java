/**
 * 918. 环形子数组的最大和：https://leetcode.cn/problems/maximum-sum-circular-subarray
 */
public class MaximumSumCircularSubarray {

    // 1. 最大子数组和在中间
    // 2. 最大子数组和在两侧：nums[0:i], nums[j:n]

    // 动态规划模拟
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int preSum = nums[0];
        int maxSubSum = nums[0];
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxSubSum = Math.max(maxSubSum, 0) + nums[i];
            ans = Math.max(ans, maxSubSum);
            preSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], preSum);
        }
        int suffixSum = 0;
        for (int i = n - 1; i >= 1; i--) {
            suffixSum += nums[i];
            ans = Math.max(ans, leftMax[i - 1] + suffixSum);
        }
        return ans;
    }

    // 逆向思维：要想使两侧的和最大，则只需要中间子数组的和最小
    public int maxSubarraySumCircular2(int[] nums) {
        int maxF = 0;
        int maxS = Integer.MIN_VALUE;
        int minF = 0;
        int minS = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxF = Math.max(maxF, 0) + num;
            maxS = Math.max(maxS, maxF);
            minF = Math.min(minF, 0) + num;
            minS = Math.min(minS, minF);
        }
        return maxS < 0 ? maxS : Math.max(maxS, sum - minS);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray app = new MaximumSumCircularSubarray();
        System.out.println(app.maxSubarraySumCircular2(new int[] {5,-3,5}));
        System.out.println(app.maxSubarraySumCircular2(new int[] {-1,3,-3,9,-6,8,-5,-5,-6,10}));
    }

}
