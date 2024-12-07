/**
 * 二进制求和：https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int n = a.length(), m = b.length();
        char[] ans = new char[n + 1];
        int carry = 0;
        for (int i = n - 1, j = m - 1; i >= 0; i--, j--) {
            int v1 = a.charAt(i) - '0';
            int v2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int v = v1 + v2 + carry;
            carry = v / 2;
            ans[i + 1] = (char) (v % 2 + '0');
        }
        if (carry == 0) {
            return new String(ans, 1, n);
        } else {
            ans[0] = (char) (carry + '0');
            return new String(ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

}
