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

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int per = sum / k;
        Arrays.sort(nums);
        if (per < nums[n - 1]) {
            return false;
        }
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per) {
                    break;
                }
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }

}
