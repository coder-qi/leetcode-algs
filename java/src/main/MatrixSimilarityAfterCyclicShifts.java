import util.ArrayUtils;

import java.util.Arrays;

/**
 * 2946. 循环移位后的矩阵相似检查：https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts
 */
public class MatrixSimilarityAfterCyclicShifts {

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        if (k == 0) {
            return true;
        }
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, t[i], 0, n);
        }
        while (k > 0) {
            for (int i = 0; i < m; i++) {
                int x = t[i][0];
                for (int j = n - 1; j > 0; j--) {
                    int nx = t[i][j];
                    t[i][j] = x;
                    x = nx;
                }
                t[i][0] = x;
            }
            k--;
        }
        return Arrays.deepEquals(t, mat);
    }

    public static void main(String[] args) {
        MatrixSimilarityAfterCyclicShifts app = new MatrixSimilarityAfterCyclicShifts();
        System.out.println(app.areSimilar(ArrayUtils.matrix("[[1,2,1,2],[5,5,5,5],[6,3,6,3]]"), 2));
        System.out.println(app.areSimilar(ArrayUtils.matrix("[[1,2]]"), 1));
    }

}
