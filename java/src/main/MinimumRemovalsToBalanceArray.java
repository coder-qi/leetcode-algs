import java.util.Arrays;

/**
 * 3634. 使数组平衡的最少移除数目：https://leetcode.cn/problems/minimum-removals-to-balance-array
 */
public class MinimumRemovalsToBalanceArray {

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while ((nums[i] + nums[j] - 1) / nums[j] > k) {
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return n - maxLen;
    }

    public int minRemoval2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] > (long)nums[j] * k) {
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return n - maxLen;
    }

}
