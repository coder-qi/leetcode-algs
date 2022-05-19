import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II：https://leetcode.cn/problems/ugly-number-ii/
 */
public class UglyNumberII {

    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3 ,5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        seen.add(1L);
        q.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = q.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = factor * curr;
                if (seen.add(next)) {
                    q.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10)); // 12
        System.out.println(nthUglyNumber(1)); // 1
        System.out.println(nthUglyNumber(1690)); // 1
    }

}
