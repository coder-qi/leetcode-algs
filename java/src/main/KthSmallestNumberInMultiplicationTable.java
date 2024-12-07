/**
 * 668. 乘法表中第k小的数：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class KthSmallestNumberInMultiplicationTable {

    public static int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = mid / n * n;
            for (int i = mid / n + 1; i <= m; i++) {
                cnt += mid / i;
            }
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(3, 3, 5)); // 3
        System.out.println(findKthNumber(2, 3, 6)); // 6
    }

}
