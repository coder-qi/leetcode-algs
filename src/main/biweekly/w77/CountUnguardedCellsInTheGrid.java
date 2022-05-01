package biweekly.w77;

import static util.ArrayUtils.matrix;

public class CountUnguardedCellsInTheGrid {

    // (rowOffset, columnOffset, value)
    static final int[][] DIRS = new int[][] {
        {-1, 0, 1}, {1, 0, 1}, {0, -1, 2}, {0, 1, 2}
    };

    // vis中的值得含义如下：
    // -2 guard
    // -1 wall
    // 0 unvisited
    // 1 left-right
    // 2 top-bottom
    int[][] vis;
    int m, n;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m;
        this.n = n;
        vis = new int[m][n];
        for (int i = 0; i < walls.length; i++) {
            vis[walls[i][0]][walls[i][1]] = -1;
        }
        for (int i = 0; i < guards.length; i++) {
            dfs(guards[i][0], guards[i][1]);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int column) {
        vis[row][column] = -2;
        for (int[] d : DIRS) {
            dfs(row + d[0], column + d[1], d);
        }
    }

    private void dfs(int row, int column, int[] d) {
        if (row < 0 || row >= m || column < 0 || column >= n || vis[row][column] < 0) {
            return;
        }
        if (vis[row][column] != d[2]) {
            vis[row][column] = d[2];
            dfs(row + d[0], column + d[1], d);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountUnguardedCellsInTheGrid().countUnguarded(4, 6,
            matrix("[[0,0],[1,1],[2,3]]"), matrix("[[0,1],[2,2],[1,4]]")));
        System.out.println(new CountUnguardedCellsInTheGrid().countUnguarded(2, 7,
            matrix("[[1,5],[1,1],[1,6],[0,2]]"), matrix("[[0,6],[0,3],[0,5]]")));
    }

}
