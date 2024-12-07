/**
 * 1768. 交替合并字符串：https://leetcode.cn/problems/merge-strings-alternately/
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length(), n = n1 + n2;
        int m = Math.min(n1, n2);
        char[] ans = new char[n];
        for (int i = 0; i < m; i++) {
            ans[i * 2] = word1.charAt(i);
            ans[i * 2 + 1] = word2.charAt(i);
        }
        if (n1 != n2) {
            String s = n1 > n2 ? word1 : word2;
            for (int i = m; i < s.length(); i++) {
                ans[m + i] = s.charAt(i);
            }
        }
        return new String(ans);
    }

}
