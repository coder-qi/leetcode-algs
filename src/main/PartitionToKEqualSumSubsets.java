import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {
        System.out.println(new PartitionToKEqualSumSubsets()
            .canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4));
        System.out.println(new PartitionToKEqualSumSubsets()
            .canPartitionKSubsets(new int[] {1,1,1,1,2,2,2,2}, 2));
    }

    int[] nums;
    int avg, n;
    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        avg = sum / k;
        Arrays.sort(nums);
        if (avg < nums[n - 1]) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, 0);
    }

    private boolean dfs(int mask, int sum) {
        if (mask == 0) {
            return true;
        }
        if (!dp[mask]) {
            return dp[mask];
        }
        dp[mask] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + sum > avg) {
                break;
            }
            if ((mask & (1 << i)) != 0) {
                if (dfs(mask ^ (1 << i), (nums[i] + sum) % avg)) {
                    return true;
                }
            }
        }
        return false;
    }

}
