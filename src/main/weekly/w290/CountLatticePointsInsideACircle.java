package weekly.w290;

import java.util.HashSet;
import java.util.Set;

import static util.ArrayUtils.matrix;

/**
 * 2249. 统计圆内格点数目：https://leetcode.cn/problems/count-lattice-points-inside-a-circle/
 */
public class CountLatticePointsInsideACircle {

    public static int countLatticePoints(int[][] circles) {
        Set<Integer> s = new HashSet<>();
        int bound = 201;
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= r * r) {
                        s.add(i + j * bound);
                    }
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        System.out.println(countLatticePoints(matrix("[[2,2,1]]"))); // 5
        System.out.println(countLatticePoints(matrix("[[2,2,2],[3,4,1]]"))); // 16
    }

}
