package biweekly.w78;

/**
 * 6069. 最大波动的子字符串：https://leetcode.cn/problems/substring-with-largest-variance/
 */
public class SubstringWithLargestVariance {

    public static int largestVariance(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                int max = 0, min = s.length();
                for (int c : cnt) {
                    if (c != 0) {
                        max = Math.max(max, c);
                        min = Math.min(min, c);
                    }
                }
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestVariance("aababbb"));
        System.out.println(largestVariance("abcde"));
    }

}
