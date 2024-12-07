package biweekly.w76;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 6063. 节点序列的最大得分：https://leetcode-cn.com/problems/maximum-score-of-a-node-sequence/
 */
public class MaximumScoreOfANodeSequence {


    public static int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<PriorityQueue<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new PriorityQueue<>(Comparator.comparingInt(a -> a[0])));
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).offer(new int[] {scores[b], b});
            graph.get(b).offer(new int[] {scores[a], a});
            if (graph.get(a).size() > 3) {
                graph.get(a).poll();
            }
            if (graph.get(b).size() > 3) {
                graph.get(b).poll();
            }
        }

        int ans = -1;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            for (int[] k : graph.get(a)) {
                int x = k[1];
                for (int[] p : graph.get(b)) {
                    int y = p[1];
                    if (x != b && y != a && x != y) {
                        ans = Math.max(ans, scores[x] + scores[a] + scores[b] + scores[y]);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] {5,2,9,8,4}, new int[][]{
            {0,1},{1,2},{2,3},{0,2},{1,3},{2,4}
        }));
        System.out.println(maximumScore(new int[] {9,20,6,4,11,12}, new int[][]{
            {0,3},{5,3},{2,4},{1,3}
        }));
    }

}
