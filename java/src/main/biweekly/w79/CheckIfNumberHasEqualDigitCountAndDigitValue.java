package biweekly.w79;

/**
 * 6083. 判断一个数的数字计数是否等于数位的值：https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {

    public static boolean digitCount(String num) {
        int[] cnt = new int[10];
        for (int i = 0; i < num.length(); i++) {
            cnt[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (i < 10 && cnt[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("6210001000"));
    }

}
