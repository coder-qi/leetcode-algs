import util.ArrayUtils;

/**
 * 3047. 求交集区域内的最大正方形面积：https://leetcode.cn/problems/find-the-largest-area-of-square-inside-two-rectangles
 */
public class FindTheLargestAreaOfSquareInsideTwoRectangles {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int maxSide = 0;
        for (int i = 0; i < n; i++) {
            if (topRight[i][0] - bottomLeft[i][0] <= maxSide || topRight[i][1] - bottomLeft[i][1] <= maxSide) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                int left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int right = Math.min(topRight[i][0], topRight[j][0]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int top = Math.min(topRight[i][1], topRight[j][1]);
                if (left < right && bottom < top) {
                    int side = Math.min(right - left, top - bottom);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }
        return (long) maxSide * maxSide;
    }

    public static void main(String[] args) {
        FindTheLargestAreaOfSquareInsideTwoRectangles app = new FindTheLargestAreaOfSquareInsideTwoRectangles();
        System.out.println(app.largestSquareArea(ArrayUtils.matrix("[[1,1],[2,2],[3,1]]"), ArrayUtils.matrix("[[3,3],[4,4],[6,6]]")));
        System.out.println(app.largestSquareArea(ArrayUtils.matrix("[[1,1],[1,3],[1,5]]"), ArrayUtils.matrix("[[5,5],[5,7],[5,9]]")));
        System.out.println(app.largestSquareArea(ArrayUtils.matrix("[[1,2],[1,2]]"), ArrayUtils.matrix("[[4,5],[2,3]]")));
    }

}
