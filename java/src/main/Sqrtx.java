/**
 * Sqrt(x)：https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrtx {

    public static int mySqrt(int x) {
        int left = 1, right = x, mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            int y = x / mid;
            if (y == mid) {
                break;
            } else if (y < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left > right ? left - 1 : mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(8)); // 2
        System.out.println(mySqrt(9)); // 3
        System.out.println(mySqrt(1)); // 1
        System.out.println(mySqrt(36)); // 6
        System.out.println(mySqrt(2147395599)); // 46339
    }

}
