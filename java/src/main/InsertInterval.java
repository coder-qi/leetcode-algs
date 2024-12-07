import java.util.ArrayList;
import java.util.List;

import util.ArrayUtils;

/**
 * 插入区间：https://leetcode-cn.com/problems/insert-interval/
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (l > newInterval[1] || r < newInterval[0]) {
                if (!inserted && l > newInterval[1]) {
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(intervals[i]);
            } else {
                if (!inserted) {
                    newInterval[0] = Math.min(newInterval[0], l);
                    result.add(newInterval);
                    inserted = true;
                }
                newInterval[1] = Math.max(newInterval[1], r);
            }
        }
        if (!inserted) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print(insert(new int[][]{
            {1,3}, {6,9}
        }, new int[] {2,5}))); // [[1,5],[6,9]]
        System.out.println("----------------------------");
        System.out.println(ArrayUtils.print(insert(new int[][]{
            {1,2},{3,5},{6,7},{8,10},{12,16}
        }, new int[] {4,8}))); // [[1,2],[3,10],[12,16]]
        System.out.println("----------------------------");
        System.out.println(ArrayUtils.print(insert(new int[][]{}, new int[] {5,7}))); // [[5,7]]
        System.out.println("----------------------------");
        System.out.println(ArrayUtils.print(insert(new int[][]{
            {1,5}
        }, new int[] {2,3}))); // [[1,5]]
        System.out.println("----------------------------");
        System.out.println(ArrayUtils.print(insert(new int[][]{
            {1,5}
        }, new int[] {2,7}))); // [[1,7]]
        System.out.println("----------------------------");
        System.out.println(ArrayUtils.print(insert(new int[][]{
            {1,5}
        }, new int[] {6,8}))); // [[1,5],[6,8]]
    }

}
