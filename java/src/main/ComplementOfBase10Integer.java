/**
 * 1009. 十进制整数的反码：https://leetcode.cn/problems/complement-of-base-10-integer
 */
public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int bits = 32 - Integer.numberOfLeadingZeros(n);
        int mask = (1 << bits) - 1;

        return (~n) & mask;
    }

}
