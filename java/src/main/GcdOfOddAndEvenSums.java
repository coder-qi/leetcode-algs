/**
 * 3658. 奇数和与偶数和的最大公约数：https://leetcode.cn/problems/gcd-of-odd-and-even-sums
 */
public class GcdOfOddAndEvenSums {

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);
        return gcd(sumOdd, sumEven);
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

}
