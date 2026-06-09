/**
 * 3689. 最大子数组总值 I：https://leetcode.cn/problems/maximum-total-subarray-value-i/
 */
public class MaximumTotalSubarrayValueI {

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) (max - min) * k;
    }

}
