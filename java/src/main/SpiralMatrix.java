import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    /**
     * 按照上右下左的顺序依次填入数据
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int k = Math.min((m + 1) / 2, (n + 1) / 2);
        List<Integer> result = new ArrayList<>(m * n);
        for (int i = 0; i < k; i++) {
            for (int j = i; j < n - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j < m - 1 - i; j++) {
                result.add(matrix[j][n - 1 - i]);
            }
            for (int j = n - 1 - i; j >= i && (m - 1 - i) != i; j--) {
                result.add(matrix[m - 1 - i][j]);
            }
            for (int j = m - 2 - i; j >= i + 1 && (n - 1 - i) != i; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {
            {1,2,3},{4,5,6},{7,8,9}
        })); // [1,2,3,6,9,8,7,4,5]
        System.out.println(spiralOrder(new int[][] {
            {1,2,3,4},{5,6,7,8},{9,10,11,12}
        })); // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(spiralOrder(new int[][] {{1}}));
        System.out.println(spiralOrder(new int[][] {
            {7},{9},{6}
        })); // [7,9,6]
    }

}
