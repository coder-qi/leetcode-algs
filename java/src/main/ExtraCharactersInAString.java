import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2707. 字符串中的额外字符：https://leetcode.cn/problems/extra-characters-in-a-string
 */
public class ExtraCharactersInAString {


    public static int minExtraChar2(String s, String[] dictionary) {
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return process(s, dictionary, 0, mem);
    }

    private static int process(String s, String[] dictionary, int index, int[] mem) {
        if (index == s.length()) {
            return 0;
        }
        if (mem[index] != -1) {
            return mem[index];
        }
        int minExtra = s.length() - index;
        for (String d : dictionary) {
            int j = s.indexOf(d, index);
            if (j != -1) {
                int p = process(s, dictionary, j + d.length(), mem) + (j - index);
                minExtra = Math.min(minExtra, p);
            }
        }
        return mem[index] = minExtra;
    }

    public static int minExtraChar3(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int minExtra = s.length() - i;
            for (String d : dictionary) {
                int j = s.indexOf(d, i);
                if (j != -1) {
                    int preIndex = j + d.length();
                    int p = (preIndex < n ? dp[preIndex] : 0) + (j - i);
                    minExtra = Math.min(minExtra, p);
                }
            }
            dp[i] = minExtra;
        }
        return dp[0];
    }

    public static int minExtraChar4(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int minExtra = s.length() - i;
            for (String d : dictionary) {
                if (s.regionMatches(i, d, 0, d.length())) {
                    int preIndex = i + d.length();
                    int p = preIndex < n ? dp[preIndex] : 0;
                    minExtra = Math.min(minExtra, p);
                }
            }
            if (i + 1 < n) {
                minExtra = Math.min(minExtra, dp[i + 1] + 1);
            }
            dp[i] = minExtra;
        }
        return dp[0];
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n];
        DictTree dt = new DictTree();
        dt.buildTree(dictionary);
        for (int i = n - 1; i >= 0; i--) {
            int minExtra = s.length() - i;
            for (int len : dt.prefixLens(s, i)) {
                int preIndex = i + len;
                int p = preIndex < n ? dp[preIndex] : 0;
                minExtra = Math.min(minExtra, p);
            }
            if (i + 1 < n) {
                minExtra = Math.min(minExtra, dp[i + 1] + 1);
            }
            dp[i] = minExtra;
        }
        return dp[0];
    }

    static class DictTree {
        final Node root = new Node();

        private void buildTree(String[] dictionary) {
            for (String d : dictionary) {
                Node cur = root;
                for (int i = 0; i < d.length(); i++) {
                    int idx = d.charAt(i) - 'a';
                    Node next = cur.next[idx];
                    if (next == null) {
                        next = cur.next[idx] = new Node();
                    }
                    cur = next;
                }
                cur.end = true;
            }
        }

        private List<Integer> prefixLens(String s, int fromIndex) {
            List<Integer> result = new ArrayList<>(8);
            Node cur = root;
            for (int i = fromIndex; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                Node next = cur.next[idx];
                if (next == null) {
                    break;
                }
                if (next.end) {
                    result.add(i - fromIndex + 1);
                }
                cur = next;
            }
            return result;
        }

    }

    static class Node {
        final Node[] next = new Node[26];
        boolean end;
    }

    public static void main(String[] args) {
        System.out.println(minExtraChar("leetscode", new String[] {"leet","code","leetcode"}));
    }

}
