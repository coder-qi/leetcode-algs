package weekly.w299;

import static util.ArrayUtils.matrix;

/**
 * 2319. 判断矩阵是否是一个 X 矩阵：https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 */
public class CheckIfMatrixIsXMatrix {

    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || n - 1 - i == j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkXMatrix(matrix("[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]"))); // true
        System.out.println(checkXMatrix(matrix("[[5,7,0],[0,3,1],[0,5,0]]"))); // false
    }

}
