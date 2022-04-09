/**
 * 颠倒二进制位：https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 & n != 0; i++) {
            result |= (1 & n) << (31 - i);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(reverseBits(-3)));
        System.out.println(Integer.toBinaryString(reverseBits(964176192)));
    }

}
