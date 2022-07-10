package weekly.w300;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2327. 知道秘密的人数：https://leetcode.cn/problems/number-of-people-aware-of-a-secret/
 */
public class NumberOfPeopleAwareOfASecret {

    static final int MOD = (int) (1e9 + 7);

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<Long> delayQ = new ArrayDeque<>(),
            propagationQ = new ArrayDeque<>();
        long delayCount = 1, propagationCount = 0;
        delayQ.offer(1L);
        for (int i = 2; i <= n; i++) {
            long count = 0;
            if (delayQ.size() == delay) {
                count = delayQ.poll();
                delayCount -= count;
                if (delayCount < 0) {
                    delayCount += MOD;
                }
            }

            propagationQ.offer(count);
            propagationCount = (propagationCount + count) % MOD;
            if (propagationQ.size() > forget - delay) {
                propagationCount -= propagationQ.poll();
                if (propagationCount < 0) {
                    propagationCount += MOD;
                }
            }

            delayCount = (delayCount + propagationCount) % MOD;
            delayQ.offer(propagationCount);
        }
        long ans = delayCount + propagationCount;
        if (ans < 0) {
            ans += MOD;
        }
        ans %= MOD;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4)); // 5
        System.out.println(peopleAwareOfSecret(4, 1, 3)); // 6
        System.out.println(peopleAwareOfSecret(1000, 1, 2)); // 2
        System.out.println(peopleAwareOfSecret(684, 18, 496)); // 653668527
        System.out.println(peopleAwareOfSecret(289, 7, 23)); // 790409951
    }

}
