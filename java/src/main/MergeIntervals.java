import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import util.ArrayUtils;

/**
 * 合并区间：https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (i == 0 || l > result.get(result.size() - 1)[1]) {
                result.add(new int[] {l, r});
            } else {
                result.get(result.size() - 1)[1] = Math.max(
                    result.get(result.size() - 1)[1], r);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print(merge(new int[][]{
            {1,3},{2,6},{8,10},{15,18}
        }))); // [[1,6],[8,10],[15,18]]
        System.out.println("-----------------------------");
        System.out.println(ArrayUtils.print(merge(new int[][]{
            {1,4},{4,5}
        }))); // [[1,6],[8,10],[15,18]]
    }

}
