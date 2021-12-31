/**
 *  两数相除：https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        // 转换为负数再处理
        boolean negative = false;
        if (dividend > 0) {
            negative = !negative;
            dividend = - dividend;
        }
        if (divisor > 0) {
            negative = !negative;
            divisor = - divisor;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            // left + right 可能会溢出
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(dividend, divisor, mid);
            if (check) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean quickAdd(int x, int y, int z) {
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                result += add;
            }
            if (z != 1) {
                add += add;
            }
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3)); // 3
        System.out.println(divide(7, -3)); // -2
    }

}
