/**
 * 854. 相似度为 K 的字符串：https://leetcode.cn/problems/k-similar-strings/
 */
public class KSimilarStrings {

    public static void main(String[] args) {
        System.out.println(new KSimilarStrings().kSimilarity("ab", "ba")); // 1
        System.out.println(new KSimilarStrings().kSimilarity("abc", "bca")); // 2
        System.out.println(new KSimilarStrings().kSimilarity("ffabc", "abffc")); // 2
        System.out.println(new KSimilarStrings().kSimilarity("abac", "baca")); // 2
    }

    int ans;

    public int kSimilarity(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1.length());
        StringBuilder sb2 = new StringBuilder(s2.length());
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }
        ans = Math.max(sb1.length() - 1, 0);
        dfs(0, 0, sb1.toString(), sb2.toString());
        return ans;
    }

    private void dfs(int pos, int cost, String str1, String str2) {
        if (cost >= ans) {
            return;
        }
        while (pos < str1.length() && str1.charAt(pos) == str2.charAt(pos)) {
            pos++;
        }
        if (pos == str1.length()) {
            ans = Math.min(ans, cost);
            return;
        }
        if (cost + minSwap(str1, str2, pos) >= ans) {
            return;
        }
        for (int i = pos + 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }
            if (str1.charAt(i) == str2.charAt(pos)) {
                String next = swap(str1, i, pos);
                dfs(pos + 1, cost + 1, next, str2);
            }
        }
    }

    int minSwap(String s1, String s2, int pos) {
        int total = 0;
        for (int i = pos; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                total++;
            }
        }
        return (total + 1) / 2;
    }

    String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
