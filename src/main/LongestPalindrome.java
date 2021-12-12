/**
 * 最长回文子串：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 暴力破解法：O(N^3)
     */
    public static String longestPalindromeBruteForce(String s) {
        StringBuilder sb = new StringBuilder();
        String result = s.length() == 0 ? "" : String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            sb.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                boolean b = true;
                for (int k = 0; k <= sb.length() / 2; k++) {
                    if (sb.charAt(k) != sb.charAt(sb.length() - 1 - k)) {
                        b = false;
                        break;
                    }
                }
                if (b && sb.length() > result.length()) {
                    result = sb.toString();
                    if (result.length() == s.length()) {
                        return result;
                    }
                }
            }
        }
        if (sb.length() > result.length()) {
            result = sb.toString();
        }
        return result;
    }

    /**
     * 思路：从后往前找对称的字符，O(n^2)
     */
    public static String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = longestPalindrome2(result, s, i);
            if (result.length() >= s.length() - i) {
                break;
            }
        }
        return result;
    }

    private static String longestPalindrome2(String max, String s, int start) {
        int l = start;
        int end = s.length() - 1;
        int r = end;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                r = --end;
                l = start;
            } else {
                l++;
                r--;
            }
        }
        if (end - start + 1 > max.length()) {
            return s.substring(start, end + 1);
        }
        return max;
    }

    public static String longestPalindrome(String s) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bacabab")); // bab
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd")); // bb
        System.out.println(longestPalindrome("a")); // a
        System.out.println(longestPalindrome("ac")); // a
    }

}
