/**
 * 1930. 长度为 3 的不同回文子序列：https://leetcode.cn/problems/unique-length-3-palindromic-subsequences
 */
public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        int[] leftCount = new int[26];
        int[] rightCount = new int[26];
        for (int i = 1; i < chars.length; i++) {
            rightCount[chars[i] - 'a']++;
        }
        int ans = 0;
        int[] visited = new int[26];
        for (int i = 1; i < chars.length - 1; i++) {
            leftCount[chars[i - 1] - 'a']++;
            rightCount[chars[i] - 'a']--;
            for (int j = 0; j < 26; j++) {
                if (leftCount[j] > 0 && rightCount[j] > 0 && (visited[chars[i] - 'a'] & (1 << j)) == 0){
                    ans++;
                    visited[chars[i] - 'a'] |= (1 << j);
                }
            }
        }
        return ans;
    }

}
