import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 934. 最短的桥：https://leetcode.cn/problems/shortest-bridge
 */
public class ShortestBridge {

    static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int m, n;
    Deque<int[]> q;

    public int shortestBridge(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return bfs(grid);
                }
            }
        }
        return 0;
    }

    private int bfs(int[][] grid) {
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pair = q.poll();
                int row = pair[0], column = pair[1];
                for (int[] d : DIRS) {
                    int nr = row + d[0], nc = column + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == -1) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        return ans;
                    }
                    grid[nr][nc] = -1;
                    q.offer(new int[] {nr, nc});
                }
            }
            ans++;
        }
        return ans;
    }

    private void dfs(int[][] grid, int row, int column) {
        if (row < 0 || row >= m || column < 0 || column >= n || grid[row][column] != 1) {
            return;
        }
        q.offer(new int[] {row, column});
        grid[row][column] = -1;
        for (int[] d : DIRS) {
            dfs(grid, row + d[0], column + d[1]);
        }
    }

}
