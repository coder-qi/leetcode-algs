/**
 * 1021. 删除最外层的括号：https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0, left = 0, cnt = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ans.append(s, left + 1, i);
                left = i + 1;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())")); // "()()()"
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // "()()()()(())"
        System.out.println(removeOuterParentheses("()()")); // ""
    }

}
