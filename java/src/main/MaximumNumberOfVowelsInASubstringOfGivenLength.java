/**
 * 1456. 定长子串中元音的最大数目：https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int count = 0;
        for(int i = 0, j = 0; i < chars.length ; i++){
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                count++;
            }
            if (i - j == k) {
                if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u') {
                    count--;
                }
                j++;
            }
            ans = Math.max(ans, count);
            if (ans == k) {
                return ans;
            }
        }
        return ans;
    }

}
