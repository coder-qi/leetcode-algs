/**
 * 2645. 构造有效字符串的最少插入数：https://leetcode.cn/problems/minimum-additions-to-make-valid-string
 */
public class MinimumAdditionsToMakeValidString {

    public static int addMinimum(String word) {
        int ans = 0;
        word = "abc" + word + "abc";
        for (int i = 1; i < word.length(); i++) {
            char cur = word.charAt(i);
            char pre = word.charAt(i - 1);
            if (cur == pre) {
                ans += 2;
            } else if (cur > pre) {
                ans += cur - pre - 1;
            } else {
                ans += (cur - 'a') + ('c' - pre);
            }
        }
        return ans;
    }

}
