/**
 * 1611. 使整数变为 0 的最少操作次数：https://leetcode.cn/problems/minimum-one-bit-operations-to-make-integers-zero
 */
public class MinimumOneBitOperationsToMakeIntegersZero {

    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        int x = Integer.toBinaryString(n).length() - 1;
        return (1 << (x + 1)) - 1 - minimumOneBitOperations(n - (1 << x));
    }

}
