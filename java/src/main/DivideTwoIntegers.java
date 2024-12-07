import java.util.ArrayList;
import java.util.List;

/**
 *  两数相除：https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    /**
     * 类二分查找法
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
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

        List<Integer> candidates = new ArrayList<>();
        candidates.add(divisor);
        int index = 0;
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) << 1);
            index++;
        }

        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; i--) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }
        return negative ? -ans : ans;
    }

    /**
     * 二分查找法
     */
    public static int divideBS(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
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
                // 避免溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return negative ? -ans : ans;
    }

    private static boolean quickAdd(int x, int y, int z) {
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < x -add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                if (add < x -add) {
                    return false;
                }
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
