import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    static final Map<Character, Character> parentheses = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    /**
     * 使用栈
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character m = parentheses.get(c);
            if (m != null) {
                if (stack.isEmpty() || stack.pop() != m) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("{[]}")); // true
    }

}
