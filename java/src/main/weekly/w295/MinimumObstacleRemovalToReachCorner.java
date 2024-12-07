package weekly.w295;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static util.ArrayUtils.matrix;

/**
 * 6081. 到达角落需要移除障碍物的最小数目：https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/
 */
public class MinimumObstacleRemovalToReachCorner {

    static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.push(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int row = p[0], column = p[1];
            for (int[] dir : DIRS) {
                int nextRow = row + dir[0], nextColumn = column + dir[1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n) {
                    continue;
                }
                if (dist[nextRow][nextColumn] > dist[row][column] + grid[nextRow][nextColumn]) {
                    dist[nextRow][nextColumn] = dist[row][column] + grid[nextRow][nextColumn];
                    if (dist[nextRow][nextColumn] == 0) {
                        q.offerFirst(new int[] { nextRow, nextColumn });
                    } else {
                        q.offerLast(new int[] { nextRow, nextColumn });
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minimumObstacles(matrix("[[0,1,1],[1,1,0],[1,1,0]]"))); // 2
        System.out.println(minimumObstacles(matrix("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]"))); // 0
    }

}
