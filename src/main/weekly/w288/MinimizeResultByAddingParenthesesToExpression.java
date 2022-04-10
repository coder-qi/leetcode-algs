package weekly.w288;

/**
 * 向表达式添加括号后的最小结果:https://leetcode-cn.com/contest/weekly-contest-288/problems/minimize-result-by-adding-parentheses-to-expression/
 */
public class MinimizeResultByAddingParenthesesToExpression {

    public static String minimizeResult(String expression) {
        int index = expression.indexOf("+");
        int left = index - 1, right = index + 1;
        int val = Integer.MAX_VALUE, resultL = 0, resultR = 0;
        while (left >= 0) {
            while (right < expression.length()) {
                int i = left == 0 ? 1 : Integer.parseInt(expression.substring(0, left));
                int j = right == expression.length() - 1 ? 1 : Integer.parseInt(expression.substring(right + 1, expression.length()));
                int t = Integer.parseInt(expression.substring(left, index)) + Integer.parseInt(expression.substring(index + 1, right + 1));
                t = i * t * j;
                if (t < val) {
                    resultL = left;
                    resultR = right;
                    val = t;
                }
                right++;
            }
            left--;
            right = index + 1;
        }
        StringBuilder result = new StringBuilder(expression);
        result.insert(resultR + 1, ')').insert(resultL, '(');
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("999+999"));
    }

}
