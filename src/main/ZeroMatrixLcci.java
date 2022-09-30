/**
 * 面试题 01.08. 零矩阵：https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class ZeroMatrixLcci {

    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] zeroRows = new boolean[m], zeroColumns = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows[i] || zeroColumns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
