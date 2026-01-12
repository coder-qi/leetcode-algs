/**
 * 1266. 访问所有点的最小时间：https://leetcode.cn/problems/minimum-time-visiting-all-points
 */
public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int[] prevPoint = points[0];
        int ans = 0;
        for (int[] point : points) {
            int x = Math.abs(point[0] - prevPoint[0]);
            int y = Math.abs(point[1] - prevPoint[1]);
            ans += Math.min(x, y) + Math.abs(x - y);
            prevPoint = point;
        }
        return ans;
    }

}
