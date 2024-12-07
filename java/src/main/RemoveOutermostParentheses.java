/**
 * 1021. 删除最外层的括号：https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0, level = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                level--;
            }
            if (level > 0) {
                ans.append(ch);
            }
            if (ch == '(') {
                level++;
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
