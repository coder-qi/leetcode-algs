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
        int n = digits.length;
        int maxIndex = n - 1;
        int index1 = -1, index2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
            } else if (digits[i] < digits[maxIndex]) {
                index1 = i;
                index2 = maxIndex;
            }
        }
        if (index1 != -1) {
            char temp = digits[index1];
            digits[index1] = digits[index2];
            digits[index2] = temp;
            return Integer.parseInt(new String(digits));
        }
        return num;
    }

}
