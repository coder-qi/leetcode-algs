import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列：https://leetcode.cn/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), ans);
        return ans;
    }

    private static void dfs(String s, int index, StringBuilder combine, List<String> ans) {
        if (index == s.length()) {
            ans.add(combine.toString());
            return;
        }
        char ch = s.charAt(index);
        combine.append(ch);
        dfs(s, index + 1, combine, ans);
        combine.setLength(combine.length() - 1);

        if (!Character.isDigit(ch)) {
            combine.append(Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
            dfs(s, index + 1, combine, ans);
            combine.setLength(combine.length() - 1);
        }
    }

}
