import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 757. 设置交集大小至少为2：https://leetcode.cn/problems/set-intersection-size-at-least-two/
 */
public class SetIntersectionSizeAtLeastTwo {

    public static void main(String[] args) {
        System.out.println(intersectionSizeTwo(matrix("[[1, 3], [1, 4], [2, 5], [3, 5]]"))); // 3
        System.out.println(intersectionSizeTwo(matrix("[[1, 2], [2, 3], [2, 4], [4, 5]]"))); // 5
    }

    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = intervals.length, m = 2;
        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<>();
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m ; j++, k++) {
                ans++;

                for (int p = i - 1; p >= 0; p--) {
                    if (intervals[p][1] < j) {
                        break;
                    }
                    temp[p].add(j);
                }
            }
        }
        return ans;
    }

}
