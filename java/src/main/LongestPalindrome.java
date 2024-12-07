/**
 * 409. 最长回文串：https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

    private static int longestPalindrome(String s) {
        int[] counts = new int[58];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
        }
        int result = 0;
        boolean hasSingleChar = false;
        for (int i = 0; i < counts.length; i++) {
            result += counts[i] - counts[i] % 2;
            if (counts[i] % 2 != 0) {
                hasSingleChar = true;
            }
        }
        if (hasSingleChar) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); // 7
        System.out.println(longestPalindrome("a")); // 1
        System.out.println(longestPalindrome("bb")); // 2
        System.out.println(longestPalindrome("aaaAaaaa")); // 7
    }

}
