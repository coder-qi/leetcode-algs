package weekly.w294;

/**
 * 6077. 巫师的总力量和：https://leetcode.cn/problems/sum-of-total-strength-of-wizards/
 */
public class SumOfTotalStrengthOfWizards {

    static final int MOD = (int) (1e9 + 7);

    public static int totalStrength(int[] strength) {
        int n = strength.length;
        /*long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + strength[i - 1]) % mod;
        }*/
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            long sum = 0;
            for (int j = i; j <= n; j++) {
                sum = (sum + strength[j - 1]) % MOD;
                min = Math.min(min, strength[j - 1]);
                ans = (ans + sum * min) % MOD;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        //System.out.println(totalStrength(ArrayUtils.array("[1,3,1,2]")));
        System.out.println(MOD);
    }

}
