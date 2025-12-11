import java.util.Arrays;

/**
 * 2466. 统计构造好字符串的方案数：https://leetcode.cn/problems/count-ways-to-build-good-strings
 */
public class CountWaysToBuildGoodStrings {

    static final int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        long ans = 0;
        int[] memo = new int[high + 1];
        Arrays.fill(memo, -1);
        for (int i = low; i <= high; i++) {
            ans += dfs(i, zero, one, memo);
            ans %= MOD;
        }
        return (int) ans;
    }

    private int dfs(int len, int zero, int one, int[] memo) {
        if (len == 0) {
            return 1;
        }
        if (len < 0) {
            return 0;
        }
        if (memo[len] != -1) {
            return memo[len];
        }
        long res = dfs(len - zero, zero, one, memo);
        res += dfs(len - one, zero, one, memo);
        return memo[len] = (int) (res % MOD);
    }

    public int countGoodStrings2(int low, int high, int zero, int one) {
        int[] f = new int[high + 1];
        f[0] = 1;
        long ans = 0;
        for (int i = Math.min(zero, one); i <= high; i++) {
            long res = i >= zero ? f[i - zero] : 0;
            res += i >= one ? f[i - one] : 0;
            f[i] = (int) (res % MOD);
            if (i >= low) {
                ans += f[i];
            }
        }
        return (int) (ans % MOD);
    }

    public int countGoodStrings3(int low, int high, int zero, int one) {
        int[] f = new int[Math.max(zero, one) + 1];
        f[0] = 1;
        long ans = 0;
        for (int i = Math.min(zero, one); i <= high; i++) {
            long res = i >= zero ? f[(i - zero) % f.length] : 0;
            res += i >= one ? f[(i - one) % f.length] : 0;
            res %= MOD;
            if (i >= low) {
                ans += res;
            }
            f[i % f.length] = (int) res;
        }
        return (int) (ans % MOD);
    }

}
