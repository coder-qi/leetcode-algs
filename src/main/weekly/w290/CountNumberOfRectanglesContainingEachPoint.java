package weekly.w290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static util.ArrayUtils.matrix;

/**
 * 2250. 统计包含每个点的矩形数目：https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point/
 */
public class CountNumberOfRectanglesContainingEachPoint {

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length;
        Arrays.sort(rectangles, (a, b) -> b[1] - a[1]);
        Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (i, j) -> points[j][1] - points[i][1]);

        int[] ans = new int[n];
        List<Integer> xs = new ArrayList<>();
        int i = 0;
        for (int id : ids) {
            int start = i;
            while (i < rectangles.length && rectangles[i][1] >= points[id][1]) {
                xs.add(rectangles[i++][0]);
            }
            if (start != i) {
                Collections.sort(xs);
            }
            ans[id] = xs.size() - lowerBound(xs, points[id][0]);
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
