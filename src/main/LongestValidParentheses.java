import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * 使用栈
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int longestValidParenthesesByStack(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    /**
     * 使用动态规划
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // ....()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // ....))
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
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
