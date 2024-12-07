import util.ArrayUtils;

/**
 * 3128. 直角三角形：https://leetcode.cn/problems/right-triangles
 */
public class RightTriangles {

    public static long numberOfRightTriangles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] leftOneCountGrid = new int[M + 1][N + 1];
        int[][] topOneCountGrid = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                leftOneCountGrid[i][j] = leftOneCountGrid[i][j - 1] + grid[i - 1][j - 1];
                topOneCountGrid[i][j] = topOneCountGrid[i - 1][j] + grid[i - 1][j - 1];
            }
        }

        long ans = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                int left = leftOneCountGrid[i][j] - 1;
                int right = leftOneCountGrid[i][N] - leftOneCountGrid[i][j];
                int top = topOneCountGrid[i][j] - 1;
                int bottom = topOneCountGrid[M][j] - topOneCountGrid[i][j];
                ans += left * top + top * right + right * bottom + bottom * left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfRightTriangles(ArrayUtils.matrix("[[1,0,0,0],[0,1,0,1],[1,0,0,0]]")));
    }

}
