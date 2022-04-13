package weekly.w288;

import java.util.Arrays;

/**
 * 花园的最大总美丽值：https://leetcode-cn.com/problems/maximum-total-beauty-of-the-gardens/
 */
public class MaximumTotalBeautyOfTheGardens {

    public static long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;
        if (flowers[0] >= target) {
            return (long)full * n;
        }
        long[] sum = new long[n];
        sum[0] = flowers[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + flowers[i];
        }
        long result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (flowers[i] >= target) {
                continue;
            }
            long m = 0;
            int left = 0, right = i;
            while (left <= right) {
                int mid = (left + right) >> 1;
                long diff = flowers[mid] * (long)(mid + 1) - sum[mid];
                if (diff > newFlowers) {
                    right = mid - 1;
                } else if (diff < newFlowers) {
                    long c = (newFlowers + sum[mid]) / (mid + 1);
                    if (c >= flowers[mid]) {
                        m = Math.min(c, mid + 1 >= i + 1 ? target - 1 : flowers[mid + 1] - 1);
                    }
                    left = mid + 1;
                } else {
                    m = flowers[mid];
                    break;
                }
            }
            result = Math.max(result, (n - i - 1) * (long)full + m * partial);
            newFlowers -= target - flowers[i];
            if (newFlowers < 0) {
                break;
            }
        }
        if (newFlowers >= 0) {
            result = Math.max(result, (long)full * n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[] {1,3,1,1}, 7, 6, 12, 1));
        System.out.println(maximumBeauty(new int[] {2,4,5,3}, 10, 5, 2, 6));
        System.out.println(maximumBeauty(new int[] {19,17,6,9,19}, 24, 10, 17, 4));
        System.out.println(maximumBeauty(new int[] {20,1,15,17,10,2,4,16,15,11}, 2, 20, 10, 2));
    }

}
