/**
 * 2536. 子矩阵元素加 1：https://leetcode.cn/problems/increment-submatrices-by-one
 */
public class IncrementSubmatricesByOne {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            matrix[row1][col1]++;
            if (col2 + 1 < n) {
                matrix[row1][col2 + 1]--;
            }
            if (row2 + 1 < n) {
                matrix[row2 + 1][col1]--;
            }
            if (row2 + 1 < n && col2 + 1 < n) {
                matrix[row2 + 1][col2 + 1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrix[j][i] += matrix[j - 1][i];
            }
        }

        return matrix;
    }

}
