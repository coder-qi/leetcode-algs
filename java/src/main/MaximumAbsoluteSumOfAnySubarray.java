/**
 * 1749. 任意子数组和的绝对值的最大值：https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray
 */
public class MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int fMax = 0;
        int fMin = 0;
        for (int num : nums) {
            fMax = Math.max(fMax, 0) + num;
            fMin = Math.min(fMin, 0) + num;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }

    public int maxAbsoluteSum2(int[] nums) {
        int mx = 0, mn = 0;
        int s = 0;
        for (int num : nums) {
            s += num;
            if (s > mx) mx = s;
            else if (s < mn) mn = s;
        }
        return mx - mn;
    }

}
