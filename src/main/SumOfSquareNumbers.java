/**
 * 633. 平方数之和：https://leetcode.cn/problems/sum-of-square-numbers/description/
 */
public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double j = Math.sqrt(c - i * i);
            if (j == (int) j) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147483645));
        long start = System.currentTimeMillis();
        System.out.println(judgeSquareSum(2147483645));
        System.out.println(System.currentTimeMillis() - start);
    }

}
