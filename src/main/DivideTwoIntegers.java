/**
 *  两数相除：https://leetcode-cn.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        int sum = 0;
        int count = 0;
        while (sum + divisor < dividend) {
            sum += divisor;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3)); // 3
        System.out.println(divide(7, -3)); // -2
    }

}
