import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int[] buckets = new int[k];
        Arrays.fill(buckets, sum / k);
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, buckets);
    }

    private static boolean dfs(int[] nums, int numIndex, int[] buckets) {
        if (numIndex < 0) {
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == nums[numIndex] || (numIndex > 0 && buckets[i] - nums[numIndex] >= nums[0])) {
                buckets[i] -= nums[numIndex];
                if (dfs(nums, numIndex - 1, buckets)) {
                    return true;
                }
                buckets[i] += nums[numIndex];
            }
        }
        return false;
    }

}
