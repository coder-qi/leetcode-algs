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
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        memo[(1 << n) - 1] = 1;
        return dfs(matchsticks, memo, 0, 0, sum / 4);
    }

    private static boolean dfs(int[] matchsticks, int[] memo, int sum, int used, int len) {
        if (memo[used] != -1) {
            return memo[used] == 1;
        }
        boolean ans = false;
        for (int i = 0; i < matchsticks.length; i++) {
            if ((used & (1 << i)) == 0 && sum + matchsticks[i] <= len
                    && dfs(matchsticks, memo, (sum + matchsticks[i]) % len,
                    used | (1 << i), len)) {
                ans = true;
                break;
            }
        }
        memo[used] = ans ? 1 : 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(array("[1,1,2,2,2]"))); // true
        System.out.println(makesquare(array("[3,3,3,3,4]"))); // false
        System.out.println(makesquare(array("[1,2,3,4,5,6,7,8,9,10,5,4,3,2,1]"))); // false
        System.out.println(makesquare(array("[5,9,10,5,4,9,6,7,6,3,4,2,5,6,10]"))); // false
        System.out.println(makesquare(array("[1,1,1,1,1,1,1,1,1,1,1,1,1,1,102]"))); // false
    }

}
