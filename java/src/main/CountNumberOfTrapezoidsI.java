import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 3623. 统计梯形的数目 I：https://leetcode.cn/problems/count-number-of-trapezoids-i
 */
public class CountNumberOfTrapezoidsI {

    private static final int MOD = 1_000_000_007;

    // 排序后，计算排列组合
    public int countTrapezoids(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        long ans = 0;
        int py = Integer.MIN_VALUE;
        int pointCount = 1;
        long total = 0;
        for (int[] point : points) {
            int y1 = point[1];
            if (y1 != py) {
                ans = ans + total * pointCount * (pointCount - 1) / 2;
                total += (long) pointCount * (pointCount - 1) / 2;
                pointCount = 1;
                py = y1;
            } else {
                pointCount++;
            }
        }
        ans = ans + total * pointCount * (pointCount - 1) / 2;
        ans %= MOD;
        return (int) ans;
    }

    // 实际上只需要计算在同一水平上的点有多少个就行了
    public int countTrapezoids2(int[][] points) {
        Map<Integer, Integer> cnt = new HashMap<>(points.length, 1);
        for (int[] point : points) {
            cnt.put(point[1], cnt.getOrDefault(point[1], 0) + 1);
        }

        long ans = 0;
        long s = 0;
        for (int c : cnt.values()) {
            long k = (long) c * (c - 1) / 2;
            ans += s * k;
            s += k;
        }
        ans %= MOD;
        return (int) ans;
    }

    public static void main(String[] args) {
        CountNumberOfTrapezoidsI app = new CountNumberOfTrapezoidsI();
        System.out.println(app.countTrapezoids(ArrayUtils.matrix("[[1,0],[2,0],[3,0],[2,2],[3,2]]")));
    }

}
