import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转换整数 (atoi)：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Atoi {

    /**
     * 简单的判断处理，代码看起来很复杂
     */
    public static int myAtoi_simple(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int pos = 0;
        char c = s.charAt(pos);
        while (c == ' ') {
            if (++pos >= s.length()) {
                break;
            }
            c = s.charAt(pos);
        }
        if (pos >= s.length()) {
            return 0;
        }
        boolean negative = false;
        char sign = s.charAt(pos);
        if (sign == '+') {
            pos++;
        } else if (sign == '-') {
            pos++;
            negative = true;
        }
        if (pos >= s.length()) {
            return 0;
        }
        long result = 0;
        c = s.charAt(pos);
        while (c >= '0' && c <= '9') {
            int digit = c - '0';
            if (negative) {
                digit = - digit;
            }
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (++pos >= s.length()) {
                break;
            }
            c = s.charAt(pos);
        }
        return (int) result;
    }

    public static int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    static class Automaton {
        private static Map<String, String[]> map = new HashMap<>() {{
            put("start", new String[] {"start", "singed", "in_number", "end"});
            put("singed", new String[] {"end", "end", "in_number", "end"});
            put("in_number", new String[] {"end", "end", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end"});
        }};
        int sign = 1;
        long ans = 0;
        private String state = "start";

        public void get(char c) {
            state = map.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min((long)Integer.MAX_VALUE, ans) : Math.min(-(long)Integer.MIN_VALUE, ans);
            } else if ("singed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("   -42")); // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words and 987")); // 0
        System.out.println(myAtoi("-91283472332")); // -2147483648
        System.out.println(myAtoi("2147483646")); // 2147483646
    }

}
