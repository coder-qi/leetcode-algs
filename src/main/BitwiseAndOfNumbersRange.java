/**
 * 数字范围按位与：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int result = 0, bits = 0;
        while (left != 0) {
            if ((left & 1) != 0) {
                long k = ((long)left + 1) << bits;
                if (k > right) {
                    result |= 1 << bits;
                }
            }
            bits++;
            left >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // 4
        System.out.println(rangeBitwiseAnd(0, 0)); // 0
        System.out.println(rangeBitwiseAnd(1, 2147483647)); // 0
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647)); // 2147483646
    }

}
