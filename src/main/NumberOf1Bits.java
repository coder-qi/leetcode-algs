/**
 * 位1的个数：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
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
