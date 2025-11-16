/**
 * 1513. 仅含 1 的子串数：https://leetcode.cn/problems/number-of-substrings-with-only-1s
 */
public class NumberOfSubstringsWithOnly1s {

    public int numSub(String s) {
        int mod = 1000000007;
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            int j = i;
            while (j + 1 < chars.length && chars[j + 1] == '1') {
                j++;
            }
            int len = j - i + 1;
            ans = (int)(ans + (long)(len + 1) * len / 2 % mod) % mod;
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSubstringsWithOnly1s app = new NumberOfSubstringsWithOnly1s();
        System.out.println(app.numSub("0110111"));
    }

}
