import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    // 栈 + 二分
    public int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        List<int[]> st = new ArrayList<>();
        st.add(new int[]{-2, -2, 0});
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1], d = 2;
            int k = lowerBound(st, start);
            int[] arr = st.get(k - 1);
            d -= st.getLast()[2] - arr[2];
            if (start <= arr[1]) {
                d -= arr[1] - start + 1;
            }
            if (d <= 0) {
                continue;
            }
            while (end - st.getLast()[1] <= d) {
                int[] c = st.removeLast();
                d += c[1] - c[0] + 1;
            }
            st.add(new int[]{end - d + 1, end, d + st.getLast()[2]});
        }
        return st.getLast()[2];
    }

    private int lowerBound(List<int[]> st, int target) {
        int left = 0, right = st.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (st.get(mid)[0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
