/**
 * Pow(x, n)：https://leetcode-cn.com/problems/powx-n/
 */
public class PowxN {

    public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = - (n + 1);
        } else {
            n--;
        }
        double result = x, product = x;
        while (n != 0) {
            if ((n & 1) != 0) {
                result *= product;
            }
            if (n != 1) {
                product *= product;
            }
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.10000, 3)); // 9.26100
        System.out.println(myPow(2.00000, -2)); // 0.25
        System.out.println(myPow(2.00000, -2147483648)); // 0.0
        System.out.println(myPow(2.10000, 100)); // 9.26100
    }

}
