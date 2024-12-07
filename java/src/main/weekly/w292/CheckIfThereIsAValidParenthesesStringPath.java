package weekly.w292;

import static util.ArrayUtils.matrixChar;

/**
 * 6059. 检查是否有合法括号字符串路径：https://leetcode-cn.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 */
public class CheckIfThereIsAValidParenthesesStringPath {

    int m, n;
    char[][] grid;
    boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') { // 不可能有效路径
            return false;
        }
        vis = new boolean[m][n][(m + n + 1) / 2];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int row, int column, int cnt) {
        if (cnt > m - row + n - column - 1) { // 后面的')'不足以抵消前面的'('
            return false;
        }
        if (row == m - 1 && column == n - 1) {
            return cnt == 1; // 终点一定时')'
        }
        if (vis[row][column][cnt]) { // 访问过的必定是false
            return false;
        }
        vis[row][column][cnt] = true;
        cnt += grid[row][column] == '(' ? 1 : -1;
        return cnt >= 0 && (row < m - 1 && dfs(row + 1, column, cnt)
            || column < n - 1 && dfs(row, column + 1, cnt));
    }

    static boolean solve(char[][] grid) {
        return new CheckIfThereIsAValidParenthesesStringPath().hasValidPath(grid);
    }

    public static void main(String[] args) {
        System.out.println(solve(matrixChar(
            "[[\"(\",\"(\",\"(\"]," +
            "[\")\",\"(\",\")\"]," +
            "[\"(\",\"(\",\")\"]," +
            "[\"(\",\"(\",\")\"]]")));
        System.out.println(solve(matrixChar("[[\")\",\")\"],[\"(\",\"(\"]]")));
    }

}
