package weekly.w290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 2250. 统计包含每个点的矩形数目：https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point/
 */
public class CountNumberOfRectanglesContainingEachPoint {

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        // 分别统计每个Y轴刻度所对应的所有X轴的值，并排序
        List<Integer>[] xs = new List[101];
        Arrays.setAll(xs, ArrayList::new);
        for (int[] rect : rectangles) {
            xs[rect[1]].add(rect[0]);
        }
        for (List<Integer> x : xs) {
            Collections.sort(x);
        }
        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = points[i][1]; j < 101; j++) {
                ans[i] += xs[j].size() - lowerBound(xs[j], points[i][0]);
            }
        }
        return ans;
    }

    private static int lowerBound(List<Integer> xs, int x) {
        int left = 0, right = xs.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (xs.get(mid) >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countRectangles(matrix("[[1,2],[2,3],[2,5]]"), matrix(" [[2,1],[1,4]]")))); //  [2,1]
        System.out.println(Arrays.toString(countRectangles(matrix("[[1,1],[2,2],[3,3]]"), matrix(" [[1,3],[1,1]]")))); //  [1,3]
    }

}
