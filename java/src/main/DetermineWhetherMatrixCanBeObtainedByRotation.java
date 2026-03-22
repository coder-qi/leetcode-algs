import java.util.Arrays;

/**
 * 1886. 判断矩阵经轮转后是否一致：https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[] row = matrix[i];
            for (int j = i + 1; j < n; j++) { // 遍历对角线上方元素，做转置
                int tmp = row[j];
                row[j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for (int j = 0; j < n / 2; j++) { // 遍历左半元素，做行翻转
                int tmp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = tmp;
            }
        }
    }

}
