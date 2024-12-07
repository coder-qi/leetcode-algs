import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static util.ArrayUtils.matrix;

/**
 * 436. 寻找右区间：https://leetcode.cn/problems/find-right-interval/
 */
public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = entry == null ? -1 : entry.getValue();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            findRightInterval(matrix("[[1,2]]")))); // [-1]
        System.out.println(Arrays.toString(
            findRightInterval(matrix("[[3,4],[2,3],[1,2]]")))); // [-1,0,1]
        System.out.println(Arrays.toString(
            findRightInterval(matrix(" [[1,4],[2,3],[3,4]]")))); // [-1,2,-1]
    }

}
