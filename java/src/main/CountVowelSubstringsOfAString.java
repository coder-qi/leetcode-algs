import java.util.Map;

/**
 * 2062. 统计字符串中的元音子字符串：https://leetcode.cn/problems/count-vowel-substrings-of-a-string
 */
public class CountVowelSubstringsOfAString {

    public int countVowelSubstrings(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> vowels = Map.of(
                'a', 1,
                'e', 2,
                'i', 4,
                'o', 8,
                'u', 16);
        int allMask = (1 << 5) - 1;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int mask = 0;
            for (int j = i; j < chars.length; j++) {
                if (vowels.containsKey(chars[j])) {
                    mask |= vowels.get(chars[j]);
                    if (mask == allMask) {
                        ans++;
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountVowelSubstringsOfAString app = new CountVowelSubstringsOfAString();
        System.out.println(app.countVowelSubstrings("aeiouu"));
    }

}
