/**
 * 1358. 包含所有三种字符的子字符串数目：https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] counts = new int[3];
        int ans = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            counts[s.charAt(right) -'a']++;
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                ans += s.length() - right;
                counts[s.charAt(left) -'a']--;
                left++;
            }
        }
        return ans;
    }

}
