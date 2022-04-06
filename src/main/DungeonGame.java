import java.util.Arrays;

/**
 * 地下城游戏：https://leetcode-cn.com/problems/dungeon-game/
 */
public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1;  j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[j] = dungeon[i][j];
                } else {
                    int right = j == n - 1 ? Integer.MIN_VALUE : dp[j + 1];
                    int bottom = i == m - 1 ? Integer.MIN_VALUE : dp[j];
                    dp[j] = dungeon[i][j] + Math.max(right, bottom);
                }
                if (dp[j] > 0) {
                    dp[j] = 0;
                }
            }
        }
        return Math.abs(dp[0]) + 1;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][] {
            {-2,-3,3},{-5,-10,1},{10,30,-5}
        }));
    }

}
