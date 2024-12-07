import static util.ArrayUtils.matrix;

/**
 * 883. 三维形体投影面积：https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionAreaOf3dShapes {

    public static int projectionArea(int[][] grid) {
        int n = grid.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int yz = 0, zx = 0;
            for (int j = 0; j < n; j++) {
                yz = Math.max(yz, grid[i][j]);
                zx = Math.max(zx, grid[j][i]);
                if (grid[i][j] != 0) {
                    result++;
                }
            }
            result += yz + zx;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(matrix("[[1,2],[3,4]]"))); // 17
        System.out.println(projectionArea(matrix("[[2]]"))); // 5
        System.out.println(projectionArea(matrix("[[1,0],[0,2]]"))); // 8
    }

}
