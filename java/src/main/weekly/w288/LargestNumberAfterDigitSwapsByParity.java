package weekly.w288;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 按奇偶性交换后的最大数字：https://leetcode-cn.com/contest/weekly-contest-288/problems/largest-number-after-digit-swaps-by-parity/
 * https://leetcode-cn.com/problems/largest-number-after-digit-swaps-by-parity/
 */
public class LargestNumberAfterDigitSwapsByParity {

    public static int largestInteger(int num) {
        Comparator<Integer> comparator = Integer::compareTo;
        comparator = comparator.reversed();
        Queue<Integer> odd = new PriorityQueue<>(comparator);
        Queue<Integer> even = new PriorityQueue<>(comparator);
        int t = num;
        while (t != 0) {
            int v = t % 10;
            if (v % 2 == 0) {
                even.offer(v);
            } else {
                odd.offer(v);
            }
            t /= 10;
        }
        int result = 0, mask = (int) Math.pow(10, odd.size() + even.size() - 1);
        t = num;
        while (!even.isEmpty() || !odd.isEmpty()) {
            int v = t / mask;
            if (v % 2 == 0) {
                result = result * 10 + even.poll();
            } else {
                result = result * 10 + odd.poll();
            }
            t %= mask;
            mask /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(65875));
        System.out.println(largestInteger(60));
    }

}
