import java.util.HashMap;
import java.util.Map;

/**
 * 3117. 划分数组得到最小的值之和：https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array
 */
public class MinimumSumOfValuesByDividingArray {

    public static int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length;
        int m = andValues.length;
        Map[][] dp = new Map[n][m];
        int res = process(nums, andValues, 0, 0, nums[0], dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int process(int[] nums, int[] andValues, int i, int j, int andValue, Map<Integer, Integer>[][] dp) {
        if (i == nums.length || j == andValues.length) {
            return i == nums.length && j == andValues.length ? 0 : Integer.MAX_VALUE;
        }
        if (dp[i][j] != null && dp[i][j].containsKey(andValue)) {
            return dp[i][j].get(andValue);
        }
        int res = Integer.MAX_VALUE;
        andValue &= nums[i];
        if ((andValue & andValues[j]) < andValues[j]) {
            return res;
        }
        if (andValue == andValues[j]) {
            int p1 = process(nums, andValues, i + 1, j + 1, i + 1 < nums.length ? nums[i + 1] : 0, dp);
            if (p1 != Integer.MAX_VALUE) {
                res = p1 + nums[i];
            }
        }
        int p2 = process(nums, andValues, i + 1, j, andValue, dp);
        res = Math.min(res, p2);
        if (dp[i][j] == null) {
            dp[i][j] = new HashMap<>();
        }
        dp[i][j].put(andValue, res);
        return res;
    }

}
