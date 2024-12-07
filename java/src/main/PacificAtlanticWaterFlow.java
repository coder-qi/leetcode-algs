import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 417. 太平洋大西洋水流问题：https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {

    static final int[][] DIRECT = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };

    int m, n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;

        boolean[][] pacificMark = new boolean[m][n];
        boolean[][] atlanticMark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificMark);
            dfs(i, n - 1, atlanticMark);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacificMark);
            dfs(m - 1, i, atlanticMark);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificMark[i][j] && atlanticMark[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int column, boolean[][] mark) {
        mark[row][column] = true;
        for (int[] d : DIRECT) {
            int nextRow = row + d[0], nextColumn = column + d[1];
            if (checkRange(nextRow, nextColumn) && !mark[nextRow][nextColumn]
                    && heights[nextRow][nextColumn] >= heights[row][column]) {
                dfs(nextRow, nextColumn, mark);
            }
        }
    }

    private boolean checkRange(int row, int column) {
        return row >= 0 && row < m && column >=0 && column < n;
    }

    public static void main(String[] args) {
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        System.out.println(new PacificAtlanticWaterFlow()
            .pacificAtlantic(matrix("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")));

        // [[0,0],[0,1],[1,0],[1,1]]
        System.out.println(new PacificAtlanticWaterFlow()
            .pacificAtlantic(matrix("[[2,1],[1,2]]")));

        // [[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]
        System.out.println(new PacificAtlanticWaterFlow()
            .pacificAtlantic(matrix("[[1,2,3],[8,9,4],[7,6,5]]")));
    }

}
