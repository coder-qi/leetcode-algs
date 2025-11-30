/**
 * 2575. 找出字符串的可整除数组：https://leetcode.cn/problems/find-the-divisibility-array-of-a-string
 */
public class FindTheDivisibilityArrayOfAString {

    public int[] divisibilityArray(String word, int m) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        int[] div = new int[n];
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = (x * 10 + chars[i] - '0') % m;
            div[i] = x == 0 ? 1 : 0;
        }
        return div;
    }

}
