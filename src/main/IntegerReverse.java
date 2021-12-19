/**
 * 整数反转：https://leetcode-cn.com/problems/reverse-integer/
 */
public class IntegerReverse {

    /**
     * 思路：先转换成反转的字符串，然后再转换成int
     */
    public static int reverseUsingString(int x) {
        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        try {
            if (sb.charAt(sb.length() - 1) == '-') {
                sb.deleteCharAt(sb.length() - 1);
                return -Integer.parseInt(sb.toString());
            } else {
                return Integer.parseInt(sb.toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            ans = ans * 10 + digit;
        }
       return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120)); // 21
        System.out.println(reverse(0)); // 0
        System.out.println(reverse(1534236469)); // 0
    }

}
