import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, 0, 0, n, new StringBuilder());
        return result;
    }

    public static void generateParenthesis(List<String> result, int l, int r, int n, StringBuilder sb) {
       if (l > n || r > n || r > l) {
           return;
       }
       if (l == n && r == n) {
           result.add(sb.toString());
           return;
       }
       sb.append('(');
       generateParenthesis(result, l + 1, r, n, sb);
       sb.setLength(sb.length() - 1);

       sb.append(')');
       generateParenthesis(result, l, r + 1, n, sb);
       sb.setLength(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
