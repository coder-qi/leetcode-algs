import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆：https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/description/
 */
public class RemovingMinimumNumberOfMagicBeans {

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] sum = new long[n];
        sum[0] = beans[0];
        for (int i = 1; i < n; i++) {
            sum[i] = beans[i] + sum[i - 1];
        }

        long k = 0;
        long p = sum[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            p = Math.min(p, k + sum[i]);
            k += (long) (beans[i + 1] - beans[i]) * (n - i - 1);
        }
        return Math.min(k, p);
    }

    public static void main(String[] args) {
        System.out.println(minimumRemoval(new int[]{4, 1, 6, 5}));
    }

}
