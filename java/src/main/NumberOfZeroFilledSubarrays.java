/**
 * 2348. 全 0 子数组的数目：https://leetcode.cn/problems/number-of-zero-filled-subarrays
 */
public class NumberOfZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int last0 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans += i - last0;
            } else {
                last0 = i;
            }
        }
        return ans;
    }

}
