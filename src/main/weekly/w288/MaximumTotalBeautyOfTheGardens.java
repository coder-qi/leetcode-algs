package weekly.w288;

import java.util.Arrays;

/**
 * 花园的最大总美丽值：https://leetcode-cn.com/problems/maximum-total-beauty-of-the-gardens/
 */
public class MaximumTotalBeautyOfTheGardens {

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;
        if (flowers[0] >= target) {
            return full * n;
        }
        long[] flowerSum = new long[n];
        flowerSum[0] = flowers[0];
        for (int i = 1; i < n; i++) {
            flowerSum[i] = flowerSum[i - 1] + flowers[i];
        }
        for (int i = n - 1; i >= 0; i--) {

        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
