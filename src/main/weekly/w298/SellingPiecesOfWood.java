package weekly.w298;

import static util.ArrayUtils.matrix;

/**
 * 2312. 卖木头块：https://leetcode.cn/problems/selling-pieces-of-wood/
 */
public class SellingPiecesOfWood {

    public static void main(String[] args) {
        System.out.println(sellingWood(3, 5, matrix("[[1,4,2],[2,2,7],[2,1,3]]"))); // 19
        System.out.println(sellingWood(4, 6, matrix("[[3,2,10],[1,4,2],[4,1,3]]"))); // 32
    }

    public static long sellingWood(int m, int n, int[][] prices) {
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) {
            pr[p[0]][p[1]] = p[2];
        }
        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = pr[i][j];
                for (int k = 1; k < i; k++) {
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }
        return f[m][n];
    }

}
