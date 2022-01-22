import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    private static Map<Integer, Integer> map = new HashMap() {
        {
            put(1, 1);
            put(2, 2);
        }
    };

    public static int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int v = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, v);
        return v;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(45)); // 1836311903
    }

}
