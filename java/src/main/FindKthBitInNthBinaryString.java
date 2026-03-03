/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位：https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string
 */
public class FindKthBitInNthBinaryString {

    public char findKthBit(int n, int k) {
        char[] s = new char[] {'0'};
        for (int i = 0; i < n; i++) {
            if (k <= s.length) {
                return s[k - 1];
            }
            char[] t = new char[s.length * 2 + 1];
            System.arraycopy(s, 0, t, 0, s.length);
            t[s.length] = '1';
            for (int j = t.length - 1; j > s.length; j--) {
                t[j] = s[t.length - j - 1] == '0' ? '1' : '0';
            }
            s = t;
        }
        return s[k - 1];
    }

}
