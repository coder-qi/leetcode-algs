import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static util.ArrayUtils.matrix;

/**
 * 1368. 使网格图至少有一条有效路径的最小代价：https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    static final int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[] {0, 0, 0});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int row = a[0], column = a[1];
            if (visited[row][column]) {
                continue;
            }
            visited[row][column] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + DIRS[i][0], nextColumn = column + DIRS[i][1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n) {
                    continue;
                }
                int curDis = a[2];
                int newDis = curDis + (grid[row][column] != i + 1 ? 1 : 0);
                if (newDis < dist[nextRow][nextColumn]) {
                    dist[nextRow][nextColumn] = newDis;
                    q.offer(new int[] {nextRow, nextColumn, newDis});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCost(matrix("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]"))); // 3
        System.out.println(minCost(matrix("[[1,1,3],[3,2,2],[1,1,4]]"))); // 0
        System.out.println(minCost(matrix("[[1,2],[4,3]]"))); // 1
        System.out.println(minCost(matrix("[[2,2,2],[2,2,2]]"))); // 3
        System.out.println(minCost(matrix("[[4]]"))); // 0
    }

}
