import util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2589. 完成所有任务的最少时间：https://leetcode.cn/problems/minimum-time-to-complete-all-tasks
 */
public class MinimumTimeToCompleteAllTasks {

    // 贪心 + 暴力
    // 区间更新问题，可以改为使用线段树
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int max = tasks[tasks.length - 1][1];
        boolean[] covered = new boolean[max + 1];
        int ans = 0;
        for (int[] task : tasks) {
            int start = task[0], end = task[1], d = task[2];
            for (int i = start; i <= end; i++) {
                if (covered[i]) {
                    d--;
                }
            }
            if (d == 0) {
                continue;
            }
            for (int i = end; d > 0; i--) {
                if (!covered[i]) {
                    covered[i] = true;
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }

    // 栈 + 二分查找
    public int findMinimumTime2(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));

        List<int[]> st = new ArrayList<>();
        st.add(new int[] {-1, -1, 0});
        for (int[] task : tasks) {
            int start = task[0], end = task[1], d = task[2];
            int k = lowerBound(st, start); // 求第一个大于等于start区间的索引k
            int[] arr = st.get(k - 1); // 区间包含的数值，前缀和的运用，sum[i, j] = sum(j) - sum(i - 1)
            d -= st.getLast()[2] - arr[2];
            if (start <= arr[1]) {
                d -= arr[1] - start + 1; // 和上个区域相交
            }
            if (d <= 0) {
                continue;
            }

            // 从右往左新增区间，并做区间合并
            while (end - st.getLast()[1] <= d) {
                int[] curr = st.removeLast();
                d += curr[1] - curr[0] + 1; // 合并
            }
            st.add(new int[] {end - d + 1, end, st.getLast()[2] + d});
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

    public static void main(String[] args) {
        MinimumTimeToCompleteAllTasks app = new MinimumTimeToCompleteAllTasks();
        System.out.println(app.findMinimumTime2(ArrayUtils.matrix("[[2,3,1],[4,5,1],[1,5,2]]"))); // 2
        System.out.println(app.findMinimumTime2(ArrayUtils.matrix("[[1,3,2],[2,5,3],[5,6,2]]"))); // 4
    }

}
