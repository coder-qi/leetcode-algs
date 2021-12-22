/**
 * 正则表达式匹配：https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    /**
     * 递归的方式来解决
     */
    public static boolean isMatchRecursive(String s, String p) {
        // 模式为空时，输入字符串必定为空，否则就是不匹配
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean matched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 先尝试不消耗掉x*的匹配，后面再尝试消耗掉一个输入字符是否能匹配
            return isMatch(s, p.substring(2)) || (matched && isMatch(s.substring(1), p));
        } else {
            // 消耗掉一个输入字符和一个模式字符
            return matched && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("ab", ".*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(isMatch("mississippi", "mis*is*ip*.")); // true
    }

}
