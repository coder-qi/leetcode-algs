import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级：https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < expression.length();) {
            int num = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }
            nums.add(num);
            if (i < expression.length()) {
                ops.add(expression.charAt(i++));
            }
        }
        int n = nums.size();
        List<Integer>[][] dp = new List[n][n];
        // dp[i][j] = dp[i][k] ops dp[k + 1][j]
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(nums.get(i));
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j] == null) {
                    dp[i][j] = new ArrayList<>();
                }
                for (int k = i; k < j; k++) {
                    for (int p : dp[i][k]) {
                        for (int q : dp[k + 1][j]) {
                            dp[i][j].add(calc(p, q, ops.get(k)));
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
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
