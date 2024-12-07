/**
 * 2369. 检查数组是否存在有效划分：https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array
 */
public class CheckIfThereIsAValidPartitionForTheArray {

    class Solution {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            if (n == 2) {
                return nums[0] == nums[1];
            }
            boolean[] dp = new boolean[n];
            dp[1] = nums[0] == nums[1];
            dp[2] = (nums[0] == nums[1] && nums[0] == nums[2])
                || (nums[0] == nums[1] - 1 && nums[0] == nums[2] - 2);
            for (int i = 3; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    if (dp[i - 2]) {
                        dp[i] = true;
                        continue;
                    }
                    if (nums[i] == nums[i - 2] && dp[i - 3]) {
                        dp[i] = true;
                        continue;
                    }
                } else {
                    if (nums[i] - nums[i - 1] == 1 && nums[i] - nums[i - 2] == 2 && dp[i - 3]) {
                        dp[i] = true;
                    }
                }
            }
            return dp[n - 1];
        }
    }

}
