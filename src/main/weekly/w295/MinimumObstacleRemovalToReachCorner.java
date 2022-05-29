package weekly.w295;

import static util.ArrayUtils.matrix;

/**
 * 6081. 到达角落需要移除障碍物的最小数目：https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/
 */
public class MinimumObstacleRemovalToReachCorner {

    static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumObstacles(matrix("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]")));
    }

}
