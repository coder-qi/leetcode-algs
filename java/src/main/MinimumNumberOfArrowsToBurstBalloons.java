import java.util.Arrays;
import java.util.Comparator;

import static util.ArrayUtils.matrix;

/**
 * 452. 用最少数量的箭引爆气球：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(matrix("[[10,16],[2,8],[1,6],[7,12]]")));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > pos) {
                ans++;
                pos = point[1];
            }
        }
        return ans;
    }

}
