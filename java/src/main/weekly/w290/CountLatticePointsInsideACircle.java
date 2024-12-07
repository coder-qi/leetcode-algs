package weekly.w290;

import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 2249. 统计圆内格点数目：https://leetcode.cn/problems/count-lattice-points-inside-a-circle/
 */
public class CountLatticePointsInsideACircle {

    public static int countLatticePoints(int[][] circles) {
        // 算出最大的坐标
        int maxX = 0, maxY = 0;
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            maxX = Math.max(maxX, x + r);
            maxY = Math.max(maxY, y + r);
;        }
        Arrays.sort(circles, (c1, c2) -> c2[2] - c1[2]); // 半径越大覆盖的面积越大
        int ans = 0;
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                for (int[] circle : circles) {
                    int x = circle[0], y = circle[1], r = circle[2];
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= r * r) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countLatticePoints(matrix("[[2,2,1]]"))); // 5
        System.out.println(countLatticePoints(matrix("[[2,2,2],[3,4,1]]"))); // 16
    }

}
