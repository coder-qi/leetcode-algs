import java.util.Arrays;

/**
 * 522. 最长特殊序列 II：https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class LongestUncommonSubsequenceII {

    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length();
            }
            return s1.compareTo(s2);
        });
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            boolean special = true;
            for (int j = 0; j < n; j++) {
                if (i != j && strs[j].length() >= strs[i].length()
                        && isSubSequence(strs[i], strs[j])) {
                    special = false;
                    break;
                }
            }
            if (special) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isSubSequence(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[] {"aba","cdc","eae"})); // 3
        System.out.println(findLUSlength(new String[] {"aaa", "aa", "aaa"})); // -1
    }

}
