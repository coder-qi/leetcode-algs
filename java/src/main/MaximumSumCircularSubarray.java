/**
 * 918. 环形子数组的最大和：https://leetcode.cn/problems/maximum-sum-circular-subarray
 */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int f = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int s = 0;
        for (int i = 0; i < n * 2; i++) {
            s += nums[i % n];
            f = Math.max(f, 0) + nums[i % n];
            ans = Math.max(ans, f);
        }
        return ans == s ? ans / 2 : ans;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray app = new MaximumSumCircularSubarray();
        System.out.println(app.maxSubarraySumCircular(new int[] {5,-3,5}));
        System.out.println(app.maxSubarraySumCircular(new int[] {-1,3,-3,9,-6,8,-5,-5,-6,10}));
    }

}
