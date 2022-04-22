/**
 * 316. 去除重复字母：https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        int left = 0, right = 0;
        while (left < n) {
            while (right < n && counts[s.charAt(right) - 'a'] != 1) {
                if (counts[s.charAt(right) - 'a'] != 0) {
                    counts[s.charAt(right) - 'a']--;
                }
                right++;
            }
            if (right < n) {
                char c = s.charAt(right);
                for (int i = right - 1; i >= left; i--) {
                    if (s.charAt(i) < c && counts[s.charAt(i) - 'a'] != 0) {
                        result.append(s.charAt(i));
                        c = s.charAt(i);
                        counts[s.charAt(i) - 'a'] = 0;
                    }
                }
                result.append(s.charAt(right));
            }

            left = right = right + 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc")); // "abc"
        System.out.println(removeDuplicateLetters("cbacdcbc")); // "acdb"
        System.out.println(removeDuplicateLetters("cdadabcc")); // "adbc"
        System.out.println(removeDuplicateLetters("abacb")); // "abc"
    }

}
