import util.ArrayUtils;

/**
 * 加一：https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] += 1;
        for (int i = n - 1; i >= 1; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtils.print(plusOne(new int[] { 1,2,3 }))); // [1,2,4]
        System.out.println(ArrayUtils.print(plusOne(new int[] { 4,3,2,1 }))); // [4,3,2,2]
        System.out.println(ArrayUtils.print(plusOne(new int[] { 0 }))); // [1]
        System.out.println(ArrayUtils.print(plusOne(new int[] { 9 }))); // [1, 0]
        System.out.println(ArrayUtils.print(plusOne(new int[] { 9,9 }))); // [1, 0]
    }

}
