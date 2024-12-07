import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2696. 删除子串后的字符串最小长度：https://leetcode.cn/problems/minimum-string-length-after-removing-substrings
 */
public class MinimumStringLengthAfterRemovingSubstrings {

    public static int minLength2(String s) {
        String s2;
        while (!(s2 = s.replaceAll("AB|CD", "")).equals(s)) {
            s = s2;
        }
        return s.length();
    }

    public static int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>(16);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ((ch == 'B' && stack.peek() == 'A') || (ch == 'D' && stack.peek() == 'C'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

}
