import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数：https://leetcode.cn/problems/get-kth-magic-number-lcci/
 */
public class GetKthMagicNumberLcci {

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(5)); // 9
        System.out.println(getKthMagicNumber(1000)); // 232
    }

    public static int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            long cur = pq.poll();
            ans = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (seen.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return ans;
    }

}
