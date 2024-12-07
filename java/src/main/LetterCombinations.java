import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    static final String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            letterCombinations(result, digits, 0, new StringBuilder());
        }
        return result;
    }

    public static void letterCombinations(List<String> result, String digits, int index, StringBuilder prefix) {
        if (index == digits.length()) {
            result.add(prefix.toString());
            return;
        }
        String str = letters[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < str.length(); i++) {
            prefix.append(str.charAt(i));
            letterCombinations(result, digits, index + 1, prefix);
            prefix.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("")); // []
        System.out.println(letterCombinations("2")); // ["a","b","c"]
    }

}
