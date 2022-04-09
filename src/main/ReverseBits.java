/**
 * 颠倒二进制位：https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        boolean positive = n > 0;
        if (positive) {
            n |= 0x80000000;
        }
        while (n != 0) {
            result <<= 1;
            result |= 1 & n;
            n >>>= 1;
        }
        if (positive) {
            result &= 0xfffffffe;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(reverseBits(-3)));
        System.out.println(Integer.toBinaryString(reverseBits(964176192)));
    }

}
