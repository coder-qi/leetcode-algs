/**
 * 1758. 生成交替二进制字符串的最少操作数：https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        int f0 = 0;
        int f1 = 0;
        for (char ch : s.toCharArray()) {
            int newF0, newF1;
            if (ch == '0') {
                newF0 = f1;
                newF1 = f0 + 1;
            } else {
                newF0 = f1 + 1;
                newF1 = f0;
            }
            f0 = newF0;
            f1 = newF1;
        }
        return Math.min(f0, f1);
    }

    public int minOperations2(String s) {
        int f0 = 0;
        int f1 = 0;
        for (char ch : s.toCharArray()) {
            int newF0 = f1 + ch - '0';
            int newF1 = f0 + '1' - ch;
            f0 = newF0;
            f1 = newF1;
        }
        return Math.min(f0, f1);
    }

}
