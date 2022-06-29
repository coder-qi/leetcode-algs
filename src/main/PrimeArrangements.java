/**
 * 1175. 质数排列：https://leetcode.cn/problems/prime-arrangements/
 */
public class PrimeArrangements {

    static final int MOD = (int) (1e9 + 7);

    public static int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return (int) (factorial(primeCount) * (long)factorial(n - primeCount) % MOD);
    }

    private static int factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        return (int) ans;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(5)); // 12
        System.out.println(numPrimeArrangements(100)); // 682289015
    }

}
