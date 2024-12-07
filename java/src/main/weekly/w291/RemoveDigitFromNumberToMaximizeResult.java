package weekly.w291;

/**
 * 6047. 移除指定数字得到的最大结果：https://leetcode-cn.com/problems/remove-digit-from-number-to-maximize-result/
 */
public class RemoveDigitFromNumberToMaximizeResult {

    public static String removeDigit(String number, char digit) {
        String ans = null;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String s = number.substring(0, i) + number.substring(i + 1);
                if (ans == null || ans.compareTo(s) < 0) {
                    ans = s;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
