import java.util.Arrays;

/**
 * 1824. 最少侧跳次数：https://leetcode.cn/problems/minimum-sideway-jumps
 */
public class MinimumSidewayJumps {

    public int minSideJumps(int[] obstacles) {
        int[][] memo = new int[obstacles.length][3];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacles, 0, 1, memo);
    }

    private int dfs(int[] obstacles, int i, int j, int[][] memo) {
        if (i == obstacles.length) {
            return 0;
        }
        if (obstacles[i] == j + 1) {
            return Integer.MAX_VALUE / 2;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = dfs(obstacles, i + 1, j, memo);
        for (int k = 0; k <= 2; k++) {
            if (k != j && obstacles[i] != k + 1) {
                res = Math.min(res, dfs(obstacles, i + 1, k, memo) + 1);
            }
        }
        return memo[i][j] = res;
    }

    public int minSideJumps2(int[] obstacles) {
        int n = obstacles.length;
        int[][] f = new int[n + 1][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    f[i][j] = Integer.MAX_VALUE / 2;
                    continue;
                }
                int res = f[i + 1][j];
                for (int k = 0; k < 3; k++) {
                    if (k != j && obstacles[i] != k + 1) {
                        res = Math.min(res, f[i + 1][k] + 1);
                    }
                }
                f[i][j] = res;
            }
        }
        return f[0][1];
    }

    public int minSideJumps3(int[] obstacles) {
        int n = obstacles.length;
        int[] f = new int[3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    f[j] = Integer.MAX_VALUE / 2;
                    continue;
                }

                int res = f[j];
                for (int k = 0; k < 3; k++) {
                    if (k != j && obstacles[i] != k + 1) {
                        res = Math.min(res, f[k] + 1);
                    }
                }
                f[j] = res;
            }
        }
        return f[1];
    }

    public static void main(String[] args) {
        MinimumSidewayJumps app = new MinimumSidewayJumps();
        System.out.println(app.minSideJumps3(new int[] { 0,1,2,3,0 }));
    }

}
