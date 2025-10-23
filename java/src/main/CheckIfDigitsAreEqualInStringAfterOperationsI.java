/**
 * 3461. 判断操作后字符串中的数字是否相等 I：https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i
 */
public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        for (int i = n; i > 2; i--) {
            for (int j = 1; j < i; j++) {
                digits[j - 1] = (digits[j - 1] + digits[j]) % 10;
            }
        }
        return digits[0] == digits[1];
    }

}
