import util.ArrayUtils;

/**
 * 螺旋矩阵 II：https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, k = (n + 1) / 2;
        for (int i = 0; i < k; i++) {
            // top
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = num++;
            }
            // right
            for (int j = i + 1; j < n - 1 - i; j++) {
                matrix[j][n - 1 - i] = num++;
            }
            if (n - 1 - i != i) {
                // bottom
                for (int j = n - 1 - i; j >= i; j--) {
                    matrix[n - 1 - i][j] = num++;
                }
                // left
                for (int j = n - 2 - i; j > i; j--) {
                    matrix[j][i] = num++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print(generateMatrix(3)));
        System.out.println("----------------------------------");
        System.out.println(ArrayUtils.print(generateMatrix(1)));
        System.out.println("----------------------------------");
        System.out.println(ArrayUtils.print(generateMatrix(2)));
        System.out.println("----------------------------------");
        System.out.println(ArrayUtils.print(generateMatrix(10)));
    }

}
