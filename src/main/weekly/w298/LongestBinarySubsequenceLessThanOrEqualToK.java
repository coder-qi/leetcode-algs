package weekly.w298;

/**
 * 6099. 小于等于 K 的最长二进制子序列：https://leetcode.cn/problems/longest-binary-subsequence-less-than-or-equal-to-k/
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {

    public int longestSubsequence(String s, int k) {
        long value = 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans++;
            } else if (ans < 31) {
                int x = 1 << ans;
                if (x + value <= k) {
                    value += x;
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        // 5
        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK().longestSubsequence("1001010", 5));
        // 6
        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK().longestSubsequence("00101001", 1));
        // 96
        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK().longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101", 11713332));
        // 92
        System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK().longestSubsequence("100110111111000000010011101000111011000001000111010001010111100001111110110010100011100100111000011011000000100001011000000100110110001101011010011", 522399436));
    }

}