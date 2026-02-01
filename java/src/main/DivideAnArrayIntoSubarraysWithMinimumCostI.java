/**
 * 3010. 将数组分成最小总代价的子数组 I：https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-i
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostI {

    public int minimumCost(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.min(ans, nums[0] + nums[i] + nums[j]);
            }
        }
        return ans;
    }

    public int minimumCost2(int[] nums) {
        int n = nums.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }

}
