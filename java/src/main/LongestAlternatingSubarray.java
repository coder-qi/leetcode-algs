/**
 * 2765. 最长交替子数组：https://leetcode.cn/problems/longest-alternating-subarray/description/
 */
public class LongestAlternatingSubarray {

    public static int alternatingSubarray(int[] nums) {
        int ans = -1;
        for (int i = 1, j = 0, flag = 1; i < nums.length;) {
            if (nums[i] - nums[i - 1] == flag) {
                flag *= -1;
                j ++;
                i ++;
                ans = Math.max(ans, j + 1);
            } else {
                if (j == 0) {
                    i++;
                }
                j = 0;
                flag = 1;
            }
        }
        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(alternatingSubarray(new int[] {2, 3, 4, 3, 4}));
    }

}
