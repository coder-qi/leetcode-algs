/**
 * 数字范围按位与：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // 4
        System.out.println(rangeBitwiseAnd(0, 0)); // 0
        System.out.println(rangeBitwiseAnd(1, 2147483647)); // 0
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647)); // 2147483646
    }

}
