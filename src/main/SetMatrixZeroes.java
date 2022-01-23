import util.ArrayUtils;

/**
 * 矩阵置零：https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColumnZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;

                }
            }
        }
        if (firstColumnZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
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
