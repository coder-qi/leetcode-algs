/**
 * 位1的个数：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    private static final int M1  = 0x55555555; // 01010101010101010101010101010101
    private static final int M2  = 0x33333333; // 00110011001100110011001100110011
    private static final int M4  = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8  = 0x00ff00ff; // 00000000111111110000000011111111
    private static final int M16 = 0x0000ffff; // 00000000000000000000000011111111

    public static int hammingWeight(int n) {
        n = ((n >>> 1) & M1) + (n & M1);
        n = ((n >>> 2) & M2) + (n & M2);
        n = ((n >>> 4) & M4) + (n & M4);
        n = ((n >>> 8) & M8) + (n & M8);
        n = ((n >>> 16) & M16) + (n & M16);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(
            Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
        System.out.println(hammingWeight(
            Integer.parseUnsignedInt("00000000000000000000000010000000", 2)));
        System.out.println(hammingWeight(
            Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
    }

}
