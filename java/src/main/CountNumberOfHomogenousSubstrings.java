/**
 * 1759. 统计同质子字符串的数目：https://leetcode.cn/problems/count-number-of-homogenous-substrings
 */
public class CountNumberOfHomogenousSubstrings {

    public int countHomogenous(String s) {
        int mod = 1000000007;
        char[] chars = s.toCharArray();
        long ans = 0;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[last]) {
                last = i;
                ans++;
            } else {
                ans += i - last + 1;
            }
        }
        return (int) (ans % mod);
    }

}
