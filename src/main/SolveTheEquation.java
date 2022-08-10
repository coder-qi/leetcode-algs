/**
 * 640. 求解方程：https://leetcode.cn/problems/solve-the-equation/
 */
public class SolveTheEquation {

    public static void main(String[] args) {
        System.out.println(solveEquation( "x+5-3+x=6+x-2")); //  "x=2"
        System.out.println(solveEquation( "x=x")); //   "Infinite solutions"
        System.out.println(solveEquation( "2x=x")); //    "x=0"
        System.out.println(solveEquation( "0x=0")); //    "Infinite solutions"
    }

    public static String solveEquation(String equation) {
        String leftExpr = equation.substring(0, equation.indexOf("="));
        String rightExpr = equation.substring(leftExpr.length() + 1);
        int[] leftItems = resolveExpression(leftExpr),
            rightItems = resolveExpression(rightExpr);
        int x = leftItems[0] - rightItems[0], c = rightItems[1] - leftItems[1];
        if (x == 0) {
            return c == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + c / x;
        }
    }

    private static int[] resolveExpression(String expr) {
        int[] result = new int[2];
        for (int i = 0, sign = 1; i < expr.length();) {
            int num = 0;
            while (i < expr.length() && expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
                num = num * 10 + (expr.charAt(i) - '0');
                i++;
            }
            if (i < expr.length() && expr.charAt(i) == 'x') {
                if (num == 0 && (i == 0 || expr.charAt(i - 1) != '0')) {
                    num = 1;
                }
                result[0] += sign * num;
                i++;
            } else {
                result[1] += sign * num;
            }
            if (i < expr.length()) {
                sign = expr.charAt(i) == '+' ? 1 : -1;
                i++;
            }
        }
        return result;
    }

}
