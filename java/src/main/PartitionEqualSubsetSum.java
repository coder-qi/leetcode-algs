import java.util.Arrays;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 416. 分割等和子集：https://leetcode.cn/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {1,5,11,5})); // true
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {1,2,3,5})); // false
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {2,2,3,5})); // false
        System.out.println(new PartitionEqualSubsetSum().canPartition(array(
            loadTestcase("416-testcase-1.txt")))); // false
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = Arrays.stream(nums).sum(), maxNum = Arrays.stream(nums).max().getAsInt();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
