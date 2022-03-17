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
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j));
                dfs(s, j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int from, int to) {
        if (mem[from][to - 1] != 0) {
            return mem[from][to - 1] == 1;
        }
        int left = from, right = to - 1;
        boolean res = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                res = false;
                break;
            }
            left++;
            right--;
        }
        mem[from][to - 1] = res ? 1 : -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("a"));
    }

}
