/**
 * 316. 去除重复字母：https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        for (int i = 0; i <  s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        boolean[] vis = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {
                char topChar;
                while (result.length() > 0 && (topChar = result.charAt(result.length() - 1)) > c) {
                    if (counts[topChar - 'a'] > 0) {
                        vis[topChar - 'a'] = false;
                        result.deleteCharAt(result.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[c - 'a'] = true;
                result.append(c);
            }
            counts[c - 'a']--;
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
