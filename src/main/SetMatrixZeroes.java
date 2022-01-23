import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.ArrayUtils;

/**
 * 矩阵置零：https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows.add(r);
                    zeroColumns.add(c);
                }
            }
        }
        for (int row : zeroRows) {
            Arrays.fill(matrix[row], 0);
        }
        for (int r = 0; r < m; r++) {
            for (int column : zeroColumns) {
               matrix[r][column] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1,1,1},{1,0,1},{1,1,1}
        };
        setZeroes(matrix);
        System.out.println(ArrayUtils.print(matrix));
        // [[1,0,1],[0,0,0],[1,0,1]]

        System.out.println("------------------------------------");
        int[][] matrix2 = new int[][] {
            {0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        setZeroes(matrix2);
        System.out.println(ArrayUtils.print(matrix2));
        // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

}
