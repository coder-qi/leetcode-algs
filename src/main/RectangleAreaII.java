import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 850. 矩形面积 II：https://leetcode.cn/problems/rectangle-area-ii/
 */
public class RectangleAreaII {

    public static void main(String[] args) {
        System.out.println(new RectangleAreaII().rectangleArea(matrix("[[0,0,2,2],[1,0,2,3],[1,0,3,1]]")));
        System.out.println(new RectangleAreaII().rectangleArea(matrix("[[0,0,1000000000,1000000000]]")));
    }

    public int rectangleArea(int[][] rectangles) {
        final int MOD = (int) (1e9 + 7);
        List<Integer> xs = new ArrayList<>();
        for (int[] rect : rectangles) {
            xs.add(rect[0]);
            xs.add(rect[2]);
        }
        Collections.sort(xs);
        long ans = 0;
        for (int i = 1; i < xs.size(); i++) {
            int x1 = xs.get(i - 1), x2 = xs.get(i), len = x2 - x1;
            if (len == 0) {
                continue;
            }
            List<int[]> lines = new ArrayList<>();
            for (int[] rect : rectangles) {
                if (x1 >= rect[0] && x2 <= rect[2]) {
                    lines.add(new int[] {rect[1], rect[3]});
                }
            }
            Collections.sort(lines, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            long total = 0, left = -1, right = -1;
            for (int[] p : lines) {
                if (p[0] > right) {
                    total += right - left;
                    left = p[0];
                    right = p[1];
                } else if (p[1] > right) {
                    right = p[1];
                }
            }
            total += right - left;
            ans += total * len;
            ans %= MOD;
        }
        return (int) ans;
    }

}
