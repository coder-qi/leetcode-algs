package weekly.w292;

/**
 * 6056. 字符串中最大的 3 位相同数字：https://leetcode-cn.com/problems/largest-3-same-digit-number-in-string/
 */
public class largest3SameDigitNumberInString {

    public static String largestGoodInteger(String num) {
        String result = "";
        for (int i = 0; i <= num.length() - 3;) {
            int j = i + 1;
            while (j < num.length() && num.charAt(i) == num.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                String substr = num.substring(i, i + 3);
                if (substr.compareTo(result) > 0) {
                    result = substr;
                }
            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339")); // 777
        System.out.println(largestGoodInteger("2300019")); // 000
        System.out.println(largestGoodInteger("42352338")); //
    }

}
