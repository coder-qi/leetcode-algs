import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数：https://leetcode-cn.com/problems/happy-number/
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while (n != 1) {
            int v = 0;
            while (n != 0) {
                int m = n % 10;
                v += m * m;
                n /= 10;
            }
            if (!nums.add(v)) {
                return false;
            }
            n = v;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

}
