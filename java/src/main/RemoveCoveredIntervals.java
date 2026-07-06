/**
 * 1288. 删除被覆盖区间：https://leetcode.cn/problems/remove-covered-intervals/
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int c = intervals[j][0];
                int d = intervals[j][1];
                if (a >= c && b <= d) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }

}
