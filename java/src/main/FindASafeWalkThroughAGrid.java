import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3286. 穿越网格图的安全路径：https://leetcode.cn/problems/find-a-safe-walk-through-a-grid
 */
public class FindASafeWalkThroughAGrid {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[] {0, 0, grid.get(0).get(0)});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int row = a[0];
            int col = a[1];
            int h = a[2];
            if (h >= health) {
                return false;
            }
            if (row == m - 1 && col == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.offer(new int[] {newRow, newCol, h + grid.get(newRow).get(newCol)});
                }
            }
        }
        return false;
    }

}
