package weekly.w298;

/**
 * 5218. 个位数字为 K 的整数之和：https://leetcode.cn/problems/sum-of-numbers-with-units-digit-k/
 */
public class SumOfNumbersWithUnitsDigitK {

    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        int a = num % 10;
        for (int i = 1; i <= 10; i++) {
            if (i * k % 10 == a && i * k <= num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumbers(10, 8));
    }

}
