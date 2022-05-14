import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. 为运算表达式设计优先级：https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int lv : left) {
                    for (int rv : right) {
                        result.add(calc(lv, rv, expression.charAt(i)));
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(expression));
        }
        memo.put(expression, result);
        return result;
    }

    private static int calc(int i, int j, char op) {
        switch (op) {
            case '+': return i + j;
            case '-': return i - j;
            default: return i * j;
        }
    }

    private static List<Integer> solve(String expression) {
        return new DifferentWaysToAddParentheses().diffWaysToCompute(expression);
    }

    public static void main(String[] args) {
        System.out.println(solve("2-1-1"));
        System.out.println(solve("2*3-4*5"));
    }

}
