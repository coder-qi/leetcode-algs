/**
 * 2048. 下一个更大的数值平衡数：https://leetcode.cn/problems/next-greater-numerically-balanced-number
 */
public class NextGreaterNumericallyBalancedNumber {

    public int nextBeautifulNumber(int n) {
        String s = String.valueOf(n);
        int res = dfs(new StringBuilder(s), 0);
        if (res == n) {
            res = dfs(new StringBuilder(String.valueOf(n + 1)), 0);
        }
        if (res == -1) {
            res = dfs(next(s.length() + 1), 0);
        }
        return res;
    }

    private StringBuilder next(int len) {
        StringBuilder s = new StringBuilder(len);
        s.append("0".repeat(len));
        return s;
    }

    private int dfs(StringBuilder s, int i) {
        if (i == s.length()) {
            return check(s) ? Integer.parseInt(s.toString()) : -1;
        }
        int num = s.charAt(i) - '0';
        if (num > s.length()) {
            return -1;
        }
        int res = dfs(s, i + 1);
        if (res == -1) {
            for (int j = num + 1; j <= s.length(); j++) {
                for (int k = i + 1; k < s.length(); k++) {
                    s.setCharAt(k, '0');
                }
                s.setCharAt(i, (char) (j + '0'));
                res = dfs(s, i + 1);
                if (res != -1) {
                    break;
                }
            }
        }
        return res;
    }

    private boolean check(StringBuilder s) {
        int[] count = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        for (int i = 0; i <= s.length(); i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NextGreaterNumericallyBalancedNumber n = new NextGreaterNumericallyBalancedNumber();
        System.out.println(n.nextBeautifulNumber(1)); // 22
        System.out.println(n.nextBeautifulNumber(1000)); // 1333
        System.out.println(n.nextBeautifulNumber(3000)); // 3133
        System.out.println(n.nextBeautifulNumber(188)); // 212
    }

}
