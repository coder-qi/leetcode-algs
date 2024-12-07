import util.ArrayUtils;

/**
 * 面试题 01.08. 零矩阵：https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class ZeroMatrixLcci {

    public static void main(String[] args) {
        int[][] matrix = ArrayUtils.matrix("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        setZeroes(matrix);
        System.out.println(ArrayUtils.print(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstColumn = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
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
        if (firstRow) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstColumn) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}
