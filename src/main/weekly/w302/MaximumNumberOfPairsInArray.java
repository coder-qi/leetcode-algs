package weekly.w302;

import java.util.Arrays;

/**
 * 6120. 数组能形成多少数对：https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class MaximumNumberOfPairsInArray {

    public static int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            ans[0] += (j - i) / 2;
            i = j;
        }
        ans[1] = nums.length - ans[0] * 2;
        return ans;
    }

    public static void main(String[] args) {

    }

}
