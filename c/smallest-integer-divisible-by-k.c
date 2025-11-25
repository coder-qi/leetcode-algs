/**
 * 1015. 可被 K 整除的最小整数：https://leetcode.cn/problems/smallest-integer-divisible-by-k/
 */

int smallestRepunitDivByK(int k) {
    if ((k & 1) == 0 || k % 5 == 0) {
        return -1;
    }
    int x = 0;
    for (int i = 1; ; i++) {
        x = (x * 10 + 1) % k;
        if (x == 0) {
            return i;
        }
    }
}