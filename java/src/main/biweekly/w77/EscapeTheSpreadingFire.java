package biweekly.w77;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 2258. 逃离火灾：https://leetcode-cn.com/problems/escape-the-spreading-fire/
 */
public class EscapeTheSpreadingFire {

    static final int[][] DIRS = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    int[][] grid;
    int m, n;

    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int left = -1, right = m * n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left < m * n ? left : (int)1e9;
    }

    private boolean check(int t) {
        boolean[][] fired = new boolean[m][n];
        List<Integer> firedCells = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fired[i][j] = true;
                    firedCells.add(i * n + j);
                }
            }
        }
        // 蔓延t分钟的火焰
        while (t-- > 0 && firedCells.size() > 0) {
            firedCells = spreadFire(fired, firedCells);
        }
        if (fired[0][0]) { // 起点着火，完蛋
            return false;
        }

        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        Deque<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                int p = q.poll();
                if (fired[p / n][p % n]) {
                    continue;
                }
                for (int[] d : DIRS) {
                    int row = p / n + d[0], column = p % n + d[1];
                    if (row >= 0 && row < m && column >= 0 && column < n
                        && !fired[row][column] && grid[row][column] != 2 && !vis[row][column]) {
                        if (row == m - 1 && column == n - 1) { // 到达安全屋
                            return true;
                        }
                        vis[row][column] = true;
                        q.add(row * n + column);
                    }
                }
                // 蔓延一分钟的火焰
            }
            firedCells = spreadFire(fired, firedCells);
        }
        return false;
    }

    private List<Integer> spreadFire(boolean[][] fired, List<Integer> firedCells) {
        List<Integer> newFiredCells = new ArrayList<>();
        for (int p : firedCells) {
            for (int[] d : DIRS) {
                int row = p / n + d[0], column = p % n + d[1];
                if (row >= 0 && row < m && column >= 0 && column < n
                    && !fired[row][column] && grid[row][column] != 2) {
                    fired[row][column] = true;
                    newFiredCells.add(row * n + column);
                }
            }
        }
        return newFiredCells;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(new EscapeTheSpreadingFire().maximumMinutes(
            matrix("[[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]")));

        // -1
        System.out.println(new EscapeTheSpreadingFire().maximumMinutes(
            matrix("[[0,0,0,0],[0,1,2,0],[0,2,0,0]]")));

        // 1e9
        System.out.println(new EscapeTheSpreadingFire().maximumMinutes(
            matrix("[[0,0,0],[2,2,0],[1,2,0]]")));

        // 0
        System.out.println(new EscapeTheSpreadingFire().maximumMinutes(
            matrix("[[0,2,0,0,1],[0,2,0,2,2],[0,2,0,0,0],[0,0,2,2,0],[0,0,0,0,0]]")));
    }

}
