/**
 * 数字范围按位与：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // 4
        System.out.println(rangeBitwiseAnd(0, 0)); // 0
        System.out.println(rangeBitwiseAnd(1, 2147483647)); // 0
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647)); // 2147483646
    }

}
