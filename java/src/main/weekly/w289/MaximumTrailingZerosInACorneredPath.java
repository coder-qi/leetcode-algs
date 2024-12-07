package weekly.w289;

/**
 * 6072. 转角路径的乘积中最多能有几个尾随零：https://leetcode-cn.com/problems/maximum-trailing-zeros-in-a-cornered-path/
 */
public class MaximumTrailingZerosInACorneredPath {

    static final int MAX_VALUE = 1000;
    static final int[][] FACTOR2_5_COUNT = new int[MAX_VALUE + 1][2];

    static {
        // 计算每个数中因子2和5的个数
        for (int i = 2; i <= MAX_VALUE; i++) {
            if (i % 2 == 0) {
                FACTOR2_5_COUNT[i][0] = FACTOR2_5_COUNT[i / 2][0] + 1;
            }
            if (i % 5 == 0) {
                FACTOR2_5_COUNT[i][1] = FACTOR2_5_COUNT[i / 5][1] + 1;
            }
        }
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] sum = new int[m][n + 1][2];
        // 计算每行的因子2和5的前缀和
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                sum[row][column + 1][0] = sum[row][column][0] + FACTOR2_5_COUNT[grid[row][column]][0];
                sum[row][column + 1][1] = sum[row][column][1] + FACTOR2_5_COUNT[grid[row][column]][1];
            }
        }
        int ans = 0;
        for (int column = 0; column < n; column++) {
            int c2 = 0, c5 = 0;
            for (int row = 0; row < m; row++) { // 从上往下
                c2 += FACTOR2_5_COUNT[grid[row][column]][0];
                c5 += FACTOR2_5_COUNT[grid[row][column]][1];
                // 左转
                int leftCnt = Math.min(c2 + sum[row][column][0], c5 + sum[row][column][1]);
                // 右转
                int rightCnt = Math.min(c2 + sum[row][n][0] - sum[row][column + 1][0],
                    c5 + sum[row][n][1] - sum[row][column + 1][1]);
                ans = Math.max(ans, Math.max(leftCnt, rightCnt));
            }
            c2 = c5 = 0;
            for (int row = m - 1; row >= 0; row--) { // 从下往上
                c2 += FACTOR2_5_COUNT[grid[row][column]][0];
                c5 += FACTOR2_5_COUNT[grid[row][column]][1];
                // 左转
                int leftCnt = Math.min(c2 + sum[row][column][0], c5 + sum[row][column][1]);
                // 右转
                int rightCnt = Math.min(c2 + sum[row][n][0] - sum[row][column + 1][0],
                    c5 + sum[row][n][1] - sum[row][column + 1][1]);
                ans = Math.max(ans, Math.max(leftCnt, rightCnt));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumTrailingZerosInACorneredPath().maxTrailingZeros(
            new int[][] {
                {23,17,15,3,20},
                {8,1,20,27,11},
                {9,4,6,2,21},
                {40,9,1,10,6},
                {22,7,4,5,3}
            }
        ));
        System.out.println(new MaximumTrailingZerosInACorneredPath().maxTrailingZeros(
            new int[][]{
                {1,5,2,4,25}
            }
        ));
    }

}
