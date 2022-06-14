package weekly.w286;

import static util.ArrayUtils.array;

/**
 * 2216. 美化数组的最少删除数：https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/
 */
public class MinimumDeletionsToMakeArrayBeautiful {

    public static int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i - ans) % 2 == 0
                && i <= n - 2 && nums[i] == nums[i + 1]) {
                ans++;
            }
        }
        if ((n - ans) % 2 != 0) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDeletion(array("[1,1,2,3,5]"))); // 1
        System.out.println(minDeletion(array("[1,1,2,2,3,3]"))); // 2
    }

}
