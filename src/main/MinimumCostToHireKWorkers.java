import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 857. 雇佣 K 名工人的最低成本：https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/
 */
public class MinimumCostToHireKWorkers {

    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[] {10,20,5}, new int[] {70,50,30}, 2));
        System.out.println(mincostToHireWorkers(new int[] {3,1,10,10,1}, new int[] {4,8,2,2,7}, 3));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(h, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);
        double result = Double.MAX_VALUE, totalQuality = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQuality += quality[h[i]];
            pq.offer(quality[h[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            totalQuality += quality[h[i]];
            pq.offer(quality[h[i]]);
            double totalWage = ((double)wage[h[i]] / quality[h[i]]) * totalQuality;
            result = Math.min(result, totalWage);
            totalQuality -= pq.poll();
        }
        return result;
    }

}
