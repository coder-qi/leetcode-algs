/**
 * 1967. 作为子字符串出现在单词中的字符串数目：https://leetcode.cn/problems/number-of-strings-that-appear-as-substrings-in-word
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {

    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                ans++;
            }
        }
        return ans;
    }

}
