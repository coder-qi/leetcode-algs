import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    /**
     * 使用回溯来解决
     */
    public static List<String> generateParenthesis_backtrace(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result, 0, 0, n, new StringBuilder());
        return result;
    }

    public static void backtrace(List<String> result, int l, int r, int n, StringBuilder sb) {
       if (l > n || r > n || r > l) {
           return;
       }
       if (l == n && r == n) {
           result.add(sb.toString());
           return;
       }
       sb.append('(');
       backtrace(result, l + 1, r, n, sb);
       sb.setLength(sb.length() - 1);

       sb.append(')');
       backtrace(result, l, r + 1, n, sb);
       sb.setLength(sb.length() - 1);
    }

    static ArrayList<String>[] cache = new ArrayList[10];

    /**
     * 按括号序列的长度递增，每一个括号序列都能用(a)b来表示
     */
    public static List<String> generateParenthesis(int n) {
        return generate(n);
    }

    private static List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generate(c)) {
                    for (String right : generate(n - c - 1)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
