/**
 * 1015. 可被 K 整除的最小整数：https://leetcode.cn/problems/smallest-integer-divisible-by-k/
 */
public class SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int k) {
        int x = k % 10;
        if ((x & 1) == 0 || x == 5) {
            return -1;
        }
        x = 0;
        for (int i = 1;; i++) {
            x = (x * 10 + 1) % k;
            if (x == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        SmallestIntegerDivisibleByK app = new SmallestIntegerDivisibleByK();
        System.out.println(app.smallestRepunitDivByK(9)); // 9
    }

}
