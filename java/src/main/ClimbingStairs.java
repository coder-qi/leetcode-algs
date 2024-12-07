import java.util.ArrayList;
import java.util.List;

/**
 * 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    private static List<Integer> cache = new ArrayList<>(45) {
        {
            add(1);
            add(2);
        }
    };

    public static int climbStairs(int n) {
        for (int i = cache.size(); i < n; i++) {
            cache.add(cache.get(i - 1) + cache.get(i - 2));
        }
        return cache.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(45)); // 1836311903
    }

}
