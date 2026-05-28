/**
 * 3120. 统计特殊字母的数量 I：https://leetcode.cn/problems/count-the-number-of-special-characters-i/
 */
public class CountTheNumberOfSpecialCharacters {

    public int numberOfSpecialChars(String word) {
        int[] counts = new int[26];
        for (char ch : word.toCharArray()) {
            if (ch >= 'a') {
                counts[ch - 'a'] |= 1;
            } else {
                counts[ch - 'A'] |= 2;
            }
        }
        int ans = 0;
        for (int count : counts) {
            if (count == 3) {
                ans++;
            }
        }
        return ans;
    }

}
