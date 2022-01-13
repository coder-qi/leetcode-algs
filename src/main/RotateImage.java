import util.ArrayUtils;

/**
 * 旋转图像：https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length, m = (n + 1) / 2;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                swap(matrix, i, j, j, n - 1 - i);
                swap(matrix, n - 1 - i, n - 1  - j, n - 1  - j, i);
            }
            for (int j = i; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - i, n - 1  - j);
            }
        }
    }

    private static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotate(matrix);
        System.out.println(ArrayUtils.print(matrix));
        // [[7,4,1],[8,5,2],[9,6,3]]

        System.out.println("---------------------");
        int[][] matrix2 = new int[][] {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        rotate(matrix2);
        System.out.println(ArrayUtils.print(matrix2));
        // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        System.out.println("---------------------");
        int[][] matrix3 = new int[][] {
            {1,2},
            {3,4}
        };
        rotate(matrix3);
        System.out.println(ArrayUtils.print(matrix3));
        // [[3,1],[4,2]]

        System.out.println("---------------------");
        int[][] matrix4 = new int[][] {{1}};
        rotate(matrix4);
        System.out.println(ArrayUtils.print(matrix4));
        // [[1]]
    }

}
