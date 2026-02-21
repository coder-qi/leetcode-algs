/**
 * 762. 二进制表示中质数个计算置位：https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    static boolean[] prime = new boolean[32];

    static {
        prime[2] = true;
        prime[3] = true;
        prime[5] = true;
        prime[7] = true;
        prime[11] = true;
        prime[13] = true;
        prime[17] = true;
        prime[19] = true;
        prime[23] = true;
        prime[29] = true;
        prime[31] = true;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (prime[Integer.bitCount(i)]) {
                ans++;
            }
        }
        return ans;
    }

}
