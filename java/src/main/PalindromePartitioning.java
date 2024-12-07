import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串：https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    List<List<String>> result;
    List<String> list;
    int[][] mem;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        mem = new int[s.length()][s.length()];
        dfs(s, 0);
        return result;
    }

    private void dfs(String s, int i) {
        if (i == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalindrome(s, i, j - 1)) {
                list.add(s.substring(i, j));
                dfs(s, j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (mem[i][j] != 0) {
            return mem[i][j] == 1;
        }
        if (i >= j) {
            mem[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            mem[i][j] = isPalindrome(s, i + 1, j - 1) ? 1 : -1;
        }
        return mem[i][j] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("a"));
    }

}
