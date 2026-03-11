/**
 * 1009. 十进制整数的反码：https://leetcode.cn/problems/complement-of-base-10-integer
 */
public class ComplementOfBase10Integer {

    public int bitwiseComplement(int n) {
        int mask = (Integer.highestOneBit(n) << 1) - 1;
        return (~n) & mask;
    }

}
