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

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int max = haystack.length() - needle.length();
        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll")); // 2
        System.out.println(strStr("aaaaa", "bba")); // -1
        System.out.println(strStr("", "")); // 0
        System.out.println(strStr("mississippi", "mississippi")); // 0
        System.out.println(strStr("aaa", "aaaa")); // -1
    }

}
