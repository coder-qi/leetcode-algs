/**
 * 693. 交替位二进制数：https://leetcode.cn/problems/binary-number-with-alternating-bits
 */
public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int bit = ~(n & 1);
        while (n != 0) {
            if (((n & 1) ^ bit) == 0) {
                return false;
            }
            bit = n & 1;
            n >>= 1;
        }
        return true;
    }

}
