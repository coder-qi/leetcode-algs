/**
 * 2972. 统计移除递增子数组的数目 II：https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii
 */
public class CountTheNumberOfIncremovableSubarraysII {

    public long incremovableSubarrayCount(int[] nums) {
        int N = nums.length;
        int left = 0;
        while (left < N - 1 && nums[left + 1] > nums[left]) {
            left++;
        }
        if (left == N - 1) {
            return (N + 1) * (long) N / 2;
        }
        int right = N - 1;
        long ans = left + 2;
        while (right == N - 1 || nums[right] < nums[right + 1]) {
            while (left >= 0 && nums[left] >= nums[right]) {
                left--;
            }
            ans += left + 2;
            right--;
        }
        return ans;
    }

}
