import java.util.Set;

/**
 * 824. 山羊拉丁文：https://leetcode-cn.com/problems/goat-latin/
 */
public class GoatLatin {

    static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static String toGoatLatin(String sentence) {
        int n = sentence.length();
        StringBuilder result = new StringBuilder();
        int left = 0, right = 0, wordCount = 0;
        while (left < n) {
            while (right < n && sentence.charAt(right) != ' ') {
                right++;
            }
            wordCount++;
            if (VOWELS.contains(sentence.charAt(left))) {
                result.append(sentence, left, right);
            } else {
                result.append(sentence, left + 1, right)
                    .append(sentence, left, left + 1);
            }
            result.append("ma");
            for (int i = 0; i < wordCount; i++) {
                result.append('a');
            }
            result.append(' ');
            right = left = right + 1;
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        // "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(toGoatLatin("I speak Goat Latin"));
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

}
