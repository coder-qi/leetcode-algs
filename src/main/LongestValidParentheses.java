import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int[] marker = new int[s.length()];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    marker[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            marker[stack.pop()] = 1;
        }

        int result = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (marker[i] == 0) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(result, count);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses("")); // 0
        System.out.println(longestValidParentheses("()(()")); // 2
        System.out.println(longestValidParentheses("((())())")); // 8
        System.out.println(longestValidParentheses("()(())")); // 6
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))(")); // 22
        System.out.println(longestValidParentheses(")(())(()()))(")); // 10
        System.out.println(longestValidParentheses("()(()(((")); // 2
    }

}
