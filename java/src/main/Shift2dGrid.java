import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 1260. 二维网格迁移：https://leetcode.cn/problems/shift-2d-grid/
 */
public class Shift2dGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
        }
        k %= m * n;
        for (int i = 0; i < m * n; i++) {
            int j = (m * n + i - k) % (m * n);
            int row = j / n, column = j % n;
            ans.get(i / n).add(grid[row][column]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // [[9,1,2],[3,4,5],[6,7,8]]
        System.out.println(shiftGrid(matrix("[[1,2,3],[4,5,6],[7,8,9]]"), 1));
        // [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
        System.out.println(shiftGrid(matrix("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]"), 4));
        // [[1,2,3],[4,5,6],[7,8,9]]
        System.out.println(shiftGrid(matrix("[[1,2,3],[4,5,6],[7,8,9]]"), 9));
        // [[6], [5], [1], [2], [3], [4], [7]]
        System.out.println(shiftGrid(matrix("[[1],[2],[3],[4],[7],[6],[5]]"), 23));
    }
}
