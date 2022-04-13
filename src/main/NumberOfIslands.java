/**
 * 岛屿数量：https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    int m, n;
    char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    visit(i, j);
                }
            }
        }
        return result;
    }

    private void visit(int row, int column) {
        if (row >= m || column >= n || row < 0 || column < 0
                || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        visit(row - 1, column);
        visit(row + 1, column);
        visit(row, column - 1);
        visit(row, column + 1);
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        })); // 1
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        })); // 3
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        })); // 1
    }

}
