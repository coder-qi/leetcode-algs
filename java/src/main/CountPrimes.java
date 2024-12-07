import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数质数：https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // 4
        System.out.println(countPrimes(0)); // 0
        System.out.println(countPrimes(1)); // 0
    }

}
