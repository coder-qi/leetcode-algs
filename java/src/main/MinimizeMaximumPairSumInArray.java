import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值：https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array
 */
public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            ans = Math.max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }

}
