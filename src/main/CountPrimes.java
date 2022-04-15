import java.util.Arrays;

/**
 * 计数质数：https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // 4
        System.out.println(countPrimes(0)); // 0
        System.out.println(countPrimes(1)); // 0
    }

}
