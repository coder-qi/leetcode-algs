import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * 3578. 统计极差最大为 K 的分割方式数：https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k
 */
public class CountPartitionsWithMaxMinDifferenceAtMostK {

    private static final int MOD = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += dp[i];

            while (!maxDeque.isEmpty() && nums[i] >= nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[i] <= nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                s -= dp[left];
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            dp[i + 1] = (int) (s % MOD);
        }
        return dp[n];
    }

    // 有序表维护最大值和最小值
    public int countPartitions2(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        long s = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s += dp[i];
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                int c = cnt.get(nums[j]);
                if (c == 1) {
                    cnt.remove(nums[j]);
                } else {
                    cnt.put(nums[j], c - 1);
                }
                s -= dp[j];
                j++;
            }
            dp[i + 1] = (int) (s % MOD);
        }
        return dp[n];
    }
    
}
