import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3098. 求出所有子序列的能量和：https://leetcode.cn/problems/find-the-sum-of-subsequence-powers
 */
public class FindTheSumOfSubsequencePowers {

    static final int MOD = 1000000007;

    public static int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int preNum = Integer.MIN_VALUE / 2;
        int min = nums[nums.length - 1] - nums[0];
        Map<String, Integer> dp = new HashMap<>();
        return process(nums, 0, preNum, min, k, dp);
    }

    private static int process(int[] nums, int index, int preNum, int min, int k, Map<String, Integer> dp) {
        if (index + k > nums.length) {
            return 0;
        }
        if (k == 0) {
            return min;
        }
        String key = index + "," + preNum + "," + min + "," + k;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = process(nums, index + 1, preNum, min, k, dp);
        res += process(nums, index + 1, nums[index], Math.min(min, nums[index] - preNum), k - 1, dp);
        res %= MOD;
        dp.put(key, res);
        return res;
    }

    public static int sumOfPowers2(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer>[][] dp = new Map[N][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = new HashMap<>();
            }
        }

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            dp[i][1].put(Integer.MAX_VALUE, 1);
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                for (int p = 2; p <= k; p++) {
                    for (Map.Entry<Integer, Integer> entry : dp[j][p - 1].entrySet()) {
                        int v = entry.getKey();
                        int count = entry.getValue();
                        int min = Math.min(diff, v);
                        dp[i][p].put(min, (dp[i][p].getOrDefault(min, 0) + count) % MOD);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : dp[i][k].entrySet()) {
                int v = entry.getKey();
                int count = entry.getValue();
                long cur = (1L * v * count) % MOD;
                res = (int) ((res + cur) % MOD);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 990202285
        System.out.println(sumOfPowers2(new int[] {
            -24, -921, 119, -291, -65, -628, 372, 274, 962, -592, -10, 67, -977, 85, -294, 349, -119, -846, -959, -79, -877, 833, 857, 44, 826, -295, -855, 554, -999, 759, -653, -423, -599, -928}, 19));
        // 10
        System.out.println(sumOfPowers2(new int[] {4,3,-1}, 2));
    }

}
