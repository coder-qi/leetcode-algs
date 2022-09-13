/**
 * 670. 最大交换：https://leetcode.cn/problems/maximum-swap/
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736)); // 7236
        System.out.println(maximumSwap(9973)); // 9973
        System.out.println(maximumSwap(1993)); // 9913
    }

    public static int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < digits.length; j++) {
               if (digits[j] >= digits[maxIndex]) {
                   maxIndex = j;
               }
            }
            if (maxIndex != i && digits[maxIndex] != digits[i]) {
                char temp = digits[maxIndex];
                digits[maxIndex] = digits[i];
                digits[i] = temp;
                return Integer.parseInt(new String(digits));
            }
        }
        return num;
    }

}
