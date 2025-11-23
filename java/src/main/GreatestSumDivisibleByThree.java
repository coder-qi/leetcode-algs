import util.ArrayUtils;

import java.util.*;

/**
 * 1262. 可被三整除的最大和：https://leetcode.cn/problems/greatest-sum-divisible-by-three
 */
public class GreatestSumDivisibleByThree {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];

        for (int i = 1; i < n; i++) {
            int k = nums[i] % 3;
            int dp0 = dp[0];
            int dp1 = dp[1];
            int dp2 = dp[2];
            if (k == 0) {
                dp[0] = dp0 + nums[i];
                dp[1] = dp1 == 0 ? 0 : (dp1 + nums[i]);
                dp[2] = dp2 == 0 ? 0 : (dp2 + nums[i]);
            } else if (k == 1) {
                dp[0] = Math.max(dp0, dp2 == 0 ? 0 : dp2 + nums[i]);
                dp[1] = Math.max(dp1, dp0 + nums[i]);
                dp[2] = Math.max(dp2, dp1 == 0 ? 0 : dp1 + nums[i]);
            } else {
                dp[0] = Math.max(dp0, dp1 == 0 ? 0 : dp1 + nums[i]);
                dp[1] = Math.max(dp1, dp2 == 0 ? 0 : dp2 + nums[i]);
                dp[2] = Math.max(dp2, dp0 + nums[i]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree app = new GreatestSumDivisibleByThree();
        System.out.println(app.maxSumDivThree(ArrayUtils.array("[3,6,5,1,8]"))); // 18
        System.out.println(app.maxSumDivThree(ArrayUtils.array("[1,2,3,4,4]"))); // 12
        System.out.println(app.maxSumDivThree(ArrayUtils.array("[972,944,817,475,436,623,900,268,25,263,627,799,38,943,968,17,813,139,772,333,498,593,567,556,550,40,4,862,915,935,366,253,994,893,47,211,332,854,73,694,37,63,789,785,419,129,170,404,854,424,712,784,539,697,478,978,509,76,528,65,194,352,986,713,730,223,858,366,71,18,60,8,835,70,349,905,446,593,909,592,95,280,900,887,303,245,612,708,7,58,564,577,718,410,512,637,535,432,332,770]"))); // 49701
    }

}
