package weekly.w288;

/**
 * 向表达式添加括号后的最小结果:https://leetcode-cn.com/contest/weekly-contest-288/problems/minimize-result-by-adding-parentheses-to-expression/
 * https://leetcode-cn.com/problems/minimize-result-by-adding-parentheses-to-expression/
 */
public class MinimizeResultByAddingParenthesesToExpression {

    public static String minimizeResult(String expression) {
        int addIndex = expression.indexOf("+"), n = expression.length();
        int value = Integer.MAX_VALUE, ansLeft = 0, ansRight = n - 1;
        for (int left = addIndex - 1; left >= 0; left--) {
            for (int right = addIndex + 1; right < n; right++) {
                int lv = left == 0 ? 1 : Integer.valueOf(expression.substring(0, left));
                int rv = right == n - 1 ? 1 : Integer.valueOf(expression.substring(right + 1, n));
                int mv = Integer.valueOf(expression.substring(left, addIndex))
                    + Integer.parseInt(expression.substring(addIndex + 1, right + 1));
                int t = lv * rv * mv;
                if (t < value) {
                    ansLeft = left;
                    ansRight = right;
                    value = t;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(expression, 0, ansLeft)
            .append('(')
            .append(expression, ansLeft, ansRight + 1)
            .append(')')
            .append(expression, ansRight + 1, expression.length());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("999+999"));
    }

}
