/**
 * 2518. 好分区的数目：https://leetcode.cn/problems/number-of-great-partitions
 */
public class NumberOfGreatPartitions {

    private static final int MOD = 1000000007;

    // 逆向思维
    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < k * 2L) {
            return 0;
        }

        int[] dp = new int[k];
        dp[0] = 1;
        int ans = 1;
        for (int num : nums) {
            ans = ans * 2 % MOD;
            for (int i = k - 1; i >= num; i--) {
                dp[i] = (dp[i] + dp[i - num]) % MOD;
            }
        }
        for (int x : dp) {
            ans = (ans - x * 2 % MOD  + MOD) % MOD;
        }
        return ans;
    }

    // 正向
    public int countPartitions2(int[] nums, int k) {
        int[][] dp = new int[k + 1][k + 1];
        dp[0][0] = 1;
        long s = 0;
        for (int num : nums) {
            for (int j = k; j >= 0; j--) {
                if (dp[k][j] != 0) {
                    int right = Math.min(j + num, k);
                    dp[k][right] = (dp[k][j] + dp[k][right]) % MOD;
                }
            }
            for (int i = s >= k ? (k - 1) : (int)s; i >= 0; i--) {
                int j = (int)Math.min(s - i, k);
                if (j < 0) {
                    continue;
                }
                if (dp[i][j] != 0) {
                    int left = Math.min(i + num, k), right = Math.min(j + num, k);
                    int prev = dp[i][j];
                    dp[i][j] = 0;
                    dp[left][j] = (prev + dp[left][j]) % MOD;
                    dp[i][right] = (prev + dp[i][right]) % MOD;
                }
            }

            s += num;
        }
        return dp[k][k];
    }

    public static void main(String[] args) {
        NumberOfGreatPartitions app = new NumberOfGreatPartitions();
        System.out.println(app.countPartitions2(new int[]{1, 2, 3, 4}, 4));
        System.out.println(app.countPartitions2(new int[]{790,555,729,447,538,657,258,716,645,349,148,860,425,401,282,889,309,720,228,39,366,107,765,546,791,938,154,85,845,656}, 558));
    }

}
