/**
 * 3754. 连接非零数字并乘以其数字和 I：https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
 */
public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        int base = 1;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            if (d != 0) {
                x += d * base;
                base *= 10;
            }
            n /= 10;
        }
        return (long) sum * x;
    }

}
