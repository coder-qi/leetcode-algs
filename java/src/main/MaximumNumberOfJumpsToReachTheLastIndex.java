import java.util.Arrays;

/**
 * 2770. 达到末尾下标所需的最大跳跃次数：https://leetcode.cn/problems/maximum-number-of-jumps-to-reach-the-last-index
 */
public class MaximumNumberOfJumpsToReachTheLastIndex {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = dfs(0, target, nums, memo);
        return ans < 0 ? -1 : ans;
    }

    private int dfs(int i, int target, int[] nums, int[] memo) {
        int n = nums.length;
        if (i == n - 1) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = Integer.MIN_VALUE / 2;
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                res = Math.max(res, dfs(j, target, nums, memo));
            }
        }
        return memo[i] = res + 1;
    }

    public int maximumJumps2(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, Integer.MIN_VALUE / 2);
        f[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i]++;
        }
        return f[0] < 0 ? -1 : f[0];
    }

}
