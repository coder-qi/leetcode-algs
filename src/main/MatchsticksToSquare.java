import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 473. 火柴拼正方形：https://leetcode.cn/problems/matchsticks-to-square/
 */
public class MatchsticksToSquare {

    public static boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                int i1 = i ^ (1 << j);
                if (dp[i1] >= 0 && dp[i1] + matchsticks[j] <= len) {
                    dp[i] = (dp[i1] + matchsticks[j]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(array("[1,1,2,2,2]"))); // true
        System.out.println(makesquare(array("[3,3,3,3,4]"))); // false
        System.out.println(makesquare(array("[1,2,3,4,5,6,7,8,9,10,5,4,3,2,1]"))); // false
        System.out.println(makesquare(array("[5,9,10,5,4,9,6,7,6,3,4,2,5,6,10]"))); // false
        System.out.println(makesquare(array("[1,1,1,1,1,1,1,1,1,1,1,1,1,1,102]"))); // false
    }

}
