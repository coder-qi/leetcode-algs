/**
 * 1582. 二进制矩阵中的特殊位置：https://leetcode.cn/problems/special-positions-in-a-binary-matrix
 */
public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isSpecialPosition(mat, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isSpecialPosition(int[][] mat, int row, int col) {
        if (mat[row][col] != 1) {
            return false;
        }
        for (int j = 0; j < mat[row].length; j++) {
            if (j != col && mat[row][j] == 1) {
                return false;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i != row && mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

}
