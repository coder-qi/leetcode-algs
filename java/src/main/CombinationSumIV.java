import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ：https://leetcode.cn/problems/combination-sum-iv
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int num : nums) {
            if (target >= num) {
                ans += dfs(nums, target - num, memo);
            }
        }
        return memo[target] = ans;
    }

    public int combinationSum2_2(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    f[i] += f[i - num];
                }
            }
        }
        return f[target];
    }

}
