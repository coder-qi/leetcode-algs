/**
 * 3713. 最长的平衡子串 I：https://leetcode.cn/problems/longest-balanced-substring-i/
 */
public class LongestBalancedSubstringI {

    public int longestBalanced(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            int[] count = new int[26];
            for (int j = i; j >= 0; j--) {
                count[str[j] - 'a']++;
                if (check(count)) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;
    }

    private boolean check(int[] count) {
        int f = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0){
                continue;
            }
            if (f == 0) {
                f = count[i];
            } else {
                if (f != count[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestBalancedSubstringI().longestBalanced("abc"));
    }

}
