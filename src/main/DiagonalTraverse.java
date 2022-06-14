import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 498. 对角线遍历：https://leetcode.cn/problems/diagonal-traverse/
 */
public class DiagonalTraverse {


    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        boolean up = true;
        int row = 0, column = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[row][column];
            row += (up ? -1 : 1);
            column += (up ? 1 : -1);
            if (row < 0 || row == m || column < 0 || column == n) {
                if (row < 0) {
                    if (column == n) {
                        row = 1;
                        column = n - 1;
                    } else {
                        row = 0;
                    }
                } else if (column < 0) {
                    if (row == m) {
                        column = 1;
                        row = m - 1;
                    } else {
                        column = 0;
                    }
                }
                if (row == m) {
                    row = m - 1;
                    column += 2;
                }
                if (column == n) {
                    column = n - 1;
                    row += 2;
                }
                up = !up;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // [1,2,4,7,5,3,6,8,9]
        System.out.println(Arrays.toString(
            findDiagonalOrder(matrix("[[1,2,3],[4,5,6],[7,8,9]]"))));
        // [1,2,3,4]
        System.out.println(Arrays.toString(
            findDiagonalOrder(matrix("[[1,2],[3,4]]"))));
        //[2,5,4,0,8,-1]
        System.out.println(Arrays.toString(
            findDiagonalOrder(matrix("[[2,5,8],[4,0,-1]]"))));
        //[1,2,3,4,5,6,7,8,9,10]
        System.out.println(Arrays.toString(
            findDiagonalOrder(matrix("[[1,2,3,4,5,6,7,8,9,10]]"))));
    }

}
