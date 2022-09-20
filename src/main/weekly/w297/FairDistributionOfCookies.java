
package weekly.w297;

import static util.ArrayUtils.array;

/**
 * 5289. 公平分发饼干：https://leetcode.cn/problems/fair-distribution-of-cookies/
 */
public class FairDistributionOfCookies {

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
            sum[i] = sum[y] + cookies[x];
        }
        
        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int min = Integer.MAX_VALUE;
                for (int x = j; x != 0; x = (x - 1) & j) {
                    min = Math.min(min, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[8,15,10,20,8]"), 2)); // 31
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[6,1,3,2,2,4,1,2]"), 3)); // 7
    }

}
