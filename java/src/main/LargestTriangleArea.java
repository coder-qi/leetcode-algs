/**
 * 812. 最大三角形面积：https://leetcode.cn/problems/largest-triangle-area/
 */
public class LargestTriangleArea {

    public static double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[j][0] - points[i][0];
                int y1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < n; k++) {
                    int x2 = points[k][0] - points[i][0];
                    int y2 = points[k][1] - points[i][1];
                    ans = Math.max(ans, Math.abs(x1 * y2 - x2 * y1) / 2.0);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
