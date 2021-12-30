/**
 * 实现 strStr()：https://leetcode-cn.com/problems/implement-strstr/
 */
public class ImplementStrstr {

    /**
     * 暴力破解
     */
    public static int strStrBruteForce(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean matched = true;
            if (haystack.length() - i < needle.length()) {
                break;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用KMP算法
     *
     * 暴力破解算法，发现不匹配的时候，都会将模式串指针重置为0，不能利用之前已经进行匹配了的信息。
     * 我们要考虑利用已经进行了匹配的前缀来进行模式字符串的指针回退
     *
     */
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ababa")); // 2
        System.out.println(strStr("hello", "ll")); // 2
        System.out.println(strStr("aaaaa", "bba")); // -1
        System.out.println(strStr("", "")); // 0
        System.out.println(strStr("mississippi", "mississippi")); // 0
        System.out.println(strStr("aaa", "aaaa")); // -1
    }

}
