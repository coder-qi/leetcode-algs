/**
 * 1252. 奇数值单元格的数目：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
public class CellsWithOddValuesInAMatrix {

    public static int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m], columns = new int[n];
        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            columns[indices[i][1]]++;
        }
        // 偶数 + 偶数 = 偶数
        // 奇数 + 奇数 = 偶数
        // 偶数 + 奇数 = 奇数
        // 矩阵中结构为偶数的个数为：行偶数 * 列奇数 + 列偶数 * 行奇数
        int rowOddCount = countOdd(rows), columnOddCount = countOdd(columns);
        return rowOddCount * (n - columnOddCount) + columnOddCount * (m - rowOddCount);
    }

    private static int countOdd(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
