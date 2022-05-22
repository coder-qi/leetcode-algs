package weekly.w294;

/**
 * 6074. 字母在字符串中的百分比：https://leetcode.cn/problems/percentage-of-letter-in-string/
 */
public class PercentageOfLetterInString {

    public static int percentageLetter(String s, char letter) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                cnt++;
            }
        }
        int ans = cnt * 100 / n;
        return ans;
    }

    public static void main(String[] args) {

    }

}
