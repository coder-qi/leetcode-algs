/**
 * 搜索二维矩阵：https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchA2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, k = m * n;
        int left = 0, right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n, column = mid % n;
            if (target < matrix[row][column]) {
                right = mid - 1;
            } else if (target > matrix[row][column]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 3)); // true
        System.out.println(searchMatrix(new int[][]{
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 13)); // false
    }

}
