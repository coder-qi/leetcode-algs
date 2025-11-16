import java.util.Set;

/**
 * 2062. 统计字符串中的元音子字符串：https://leetcode.cn/problems/count-vowel-substrings-of-a-string
 */
public class CountVowelSubstringsOfAString {

    public int countVowelSubstrings(String word) {
        char[] chars = word.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int[] counts = new int[26];
            for (int j = i; j < chars.length; j++) {
                char ch = chars[j];
                counts[ch - 'a']++;
                if (hasOnlyVowels(vowels, counts)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean hasOnlyVowels(Set<Character> vowels, int[] counts) {
        for (char vowel : vowels) {
            if (counts[vowel - 'a'] == 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (vowels.contains(ch)) {
                continue;
            }
            if (counts[ch - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountVowelSubstringsOfAString app = new CountVowelSubstringsOfAString();
        System.out.println(app.countVowelSubstrings("aeiouu"));
    }

}
