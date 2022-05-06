import java.util.Deque;
import java.util.LinkedList;

/**
 * 933. 最近的请求次数：https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {

    static class RecentCounter {

        Deque<Integer> q = new LinkedList<>();

        public RecentCounter() {
        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3

        System.out.println("-------------------------");
        recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(641));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));
        System.out.println(recentCounter.ping(5936));
        System.out.println(recentCounter.ping(5957));

    }

}
