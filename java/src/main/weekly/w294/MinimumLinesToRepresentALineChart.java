package weekly.w294;

import java.util.Arrays;
import java.util.Comparator;

import util.ArrayUtils;

/**
 * 6076. 表示一个折线图的最少线段数：https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart/
 */
public class MinimumLinesToRepresentALineChart {

    public static int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n <= 1) {
            return 0;
        }
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
        int ans = 1;
        int x = stockPrices[1][0] - stockPrices[0][0];
        int y = stockPrices[1][1] - stockPrices[0][1];
        for (int i = 2; i < stockPrices.length; i++) {
            int x2 = stockPrices[i][0] - stockPrices[i - 1][0];
            int y2 = stockPrices[i][1] - stockPrices[i - 1][1];
            if (x * (long)y2 - x2 * (long)y != 0) {
                ans++;
                x = x2;
                y = y2;
            }
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(minimumLines(ArrayUtils.matrix("[[3,4],[1,2],[7,8],[2,3]]")));
    }

}
