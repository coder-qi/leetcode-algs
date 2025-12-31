import util.ArrayUtils;

/**
 * 1970. 你能穿过矩阵的最后一天：https://leetcode.cn/problems/last-day-where-you-can-still-cross
 */
public class LastDayWhereYouCanStillCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] waterDays = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            waterDays[r][c] = i + 1;
        }
        int l = 1;
        int r = row * col;
        int[][] vis = new int[row + 1][col + 1];
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(waterDays, mid, vis)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }

    private boolean check(int[][] waterDays, int day, int[][] vis) {
        int col = waterDays[0].length;
        for (int j = 0; j < col; j++) {
            if (dfs(waterDays, 0, j, day, vis)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] waterDays, int i, int j, int day, int[][] vis) {
        int row = waterDays.length;
        int col = waterDays[0].length;
        if (i < 0 || j < 0 || j == col || vis[i][j] == day) {
            return false;
        }
        if (i == row) {
            return true;
        }
        vis[i][j] = day;
        return waterDays[i][j] > day &&
                (dfs(waterDays, i - 1, j, day, vis) || dfs(waterDays, i + 1, j, day, vis) ||
                dfs(waterDays, i, j - 1, day, vis) || dfs(waterDays, i, j + 1, day, vis));
    }

    public static void main(String[] args) {
        LastDayWhereYouCanStillCross app = new LastDayWhereYouCanStillCross();
        System.out.println(app.latestDayToCross(2, 2, ArrayUtils.matrix("[[1,1],[2,1],[1,2],[2,2]]")));
    }

}
