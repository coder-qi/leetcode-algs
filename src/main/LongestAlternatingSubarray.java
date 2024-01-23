/**
 * 2765. 最长交替子数组：https://leetcode.cn/problems/longest-alternating-subarray/description/
 */
public class LongestAlternatingSubarray {

    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, flag = 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == flag) {
                    flag *= -1;
                    ans = Math.max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return ans;
    }

}
