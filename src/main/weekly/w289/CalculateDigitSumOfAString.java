package weekly.w289;

/**
 * 6070. 计算字符串的数字和：https://leetcode-cn.com/problems/calculate-digit-sum-of-a-string/
 */
public class CalculateDigitSumOfAString {

    public static String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int v = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    v += s.charAt(j) - '0';
                }
                sb.append(v);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum("00000000", 3));
    }

}
