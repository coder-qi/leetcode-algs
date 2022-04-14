/**
 * 快乐数：https://leetcode-cn.com/problems/happy-number/
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        int slow = n, fast = nextNumber(n);
        while (fast != 1 && fast != slow) {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
        }
        return fast == 1;
    }

    private static int nextNumber(int n) {
        int sum = 0;
        while (n != 0) {
            int m = n % 10;
            sum += m * m;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

}
