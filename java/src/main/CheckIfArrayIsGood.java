import util.ArrayUtils;

import java.util.Arrays;

/**
 * 2784. 检查数组是否是好的：https://leetcode.cn/problems/check-if-array-is-good
 */
public class CheckIfArrayIsGood {

    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] != 1 || nums[n - 1] != n - 1) {
            return false;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }

}
