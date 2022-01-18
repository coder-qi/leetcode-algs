/**
 * 有效数字：https://leetcode-cn.com/problems/valid-number/
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
        }
        boolean allowSign = false;
        boolean exp = false;
        boolean digit = false;
        boolean dot = false;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = true;
                if (exp) {
                    allowSign = false;
                }
            } else if (c == '+' || c == '-') {
                if (!allowSign || i == s.length() - 1) {
                    return false;
                }
                allowSign = false;
            } else if (c == '.') {
                if (dot || exp || (i == s.length() - 1 && !digit)) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !digit || i == s.length() - 1) {
                    return false;
                }
                allowSign = true;
                exp = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = { "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
            "3e+7", "+6e-1", "53.5e93", "-123.456e789" };
        System.out.println("-----------------true-----------");
        for (String str : arr) {
            System.out.println(isNumber(str));
        }

        String[] arr2 = { "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53" };
        System.out.println("-----------------false-----------");
        for (String str2 : arr2) {
            System.out.println(isNumber(str2));
        }
        System.out.println("-----------------example-----------");
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("4e+"));
    }

}
