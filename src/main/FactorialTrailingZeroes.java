/**
 * 阶乘后的零：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int result = 0;
        while (n >= 5) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(0));
        System.out.println(trailingZeroes(20));
        System.out.println(trailingZeroes(2000));
        System.out.println(trailingZeroes(30));
        System.out.println(trailingZeroes(300));
        System.out.println(trailingZeroes(250));
    }

}
