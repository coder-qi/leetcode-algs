import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串：https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, result, list);
        return result;
    }

    private static void dfs(String s, int i, List<List<String>> result, List<String> list) {
        if (i == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j));
                dfs(s, j, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int from, int to) {
        int left = from, right = to - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
    }

}
