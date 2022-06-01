import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 473. 火柴拼正方形：https://leetcode.cn/problems/matchsticks-to-square/
 */
public class MatchsticksToSquare {

    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return dfs(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    private static boolean dfs(int[] matchsticks, int index, int[] a, int avg) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            a[i] += matchsticks[index];
            if (a[i] <= avg && dfs(matchsticks, index - 1, a, avg)) {
                return true;
            }
            a[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(array("[1,1,2,2,2]"))); // true
        System.out.println(makesquare(array("[3,3,3,3,4]"))); // false
        System.out.println(makesquare(array("[1,2,3,4,5,6,7,8,9,10,5,4,3,2,1]"))); // false
        System.out.println(makesquare(array("[5,9,10,5,4,9,6,7,6,3,4,2,5,6,10]"))); // false
        System.out.println(makesquare(array("[1,1,1,1,1,1,1,1,1,1,1,1,1,1,102]"))); // false
    }

}
