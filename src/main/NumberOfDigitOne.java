/**
 * 233. 数字 1 的个数：https://leetcode.cn/problems/number-of-digit-one/
 */
public class NumberOfDigitOne {

    public static void main(String[] args) {
        System.out.println(countDigitOne(2));
        System.out.println(countDigitOne(100));
    }

    public static int countDigitOne(int n) {
        int ans = 0;
        for (int x = 1; x <= n; x *= 10) {
            ans += (n / (x * 10)) * x + Math.min(x, Math.max(n % (x * 10) - x + 1, 0));
        }
        return ans;
    }



}
