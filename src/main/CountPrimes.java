/**
 * 计数质数：https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2, end = (int) Math.sqrt(n); i <= end; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // 4
        System.out.println(countPrimes(0)); // 0
        System.out.println(countPrimes(1)); // 0
    }

}
