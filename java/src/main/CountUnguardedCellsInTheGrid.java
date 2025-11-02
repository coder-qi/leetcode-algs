/**
 * 2257. 统计网格图中没有被保卫的格子数：https://leetcode.cn/problems/count-unguarded-cells-in-the-grid
 */
public class CountUnguardedCellsInTheGrid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int column = guard[1];
            for (int i = column - 1; i >= 0; i--) {
                if (grid[row][i] == 'W' || grid[row][i] == 'G') {
                    break;
                }
                grid[row][i] = 'V';
            }
            for (int i = column + 1; i < n; i++) {
                if (grid[row][i] == 'W' || grid[row][i] == 'G') {
                    break;
                }
                grid[row][i] = 'V';
            }
            for (int i = row - 1; i >= 0; i--) {
                if (grid[i][column] == 'W' || grid[i][column] == 'G') {
                    break;
                }
                grid[i][column] = 'V';
            }
            for (int i = row + 1; i < m; i++) {
                if (grid[i][column] == 'W' || grid[i][column] == 'G') {
                    break;
                }
                grid[i][column] = 'V';
            }
        }

        int res = 0;
        for (char[] chars : grid) {
            for (char c : chars) {
                if (c == 0) {
                    res++;
                }
            }
        }
        return res;
    }

}
