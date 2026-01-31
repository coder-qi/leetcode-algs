import java.util.*;

/**
 * 3650. 边反转的最小路径总成本：https://leetcode.cn/problems/minimum-cost-path-with-edge-reversals
 */
public class MinimumCostPathWithEdgeReversals {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w * 2});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[1]));
        dis[0] = 0;
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int w = cur[1];
            if (w > dis[u]) {
                continue;
            }
            if (u == n - 1) {
                return w;
            }
            for (int[] e : g[u]) {
                int v = e[0];
                int vw = e[1];
                int newW = w + vw;
                if (newW < dis[v]) {
                    dis[v] = newW;
                    pq.offer(new int[] {v, newW});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumCostPathWithEdgeReversals app = new MinimumCostPathWithEdgeReversals();
        System.out.println(app.minCost(4, new int[][]{
                new int[] {0,1,3},
                new int[] {3,1,1},
                new int[] {2,3,4},
                new int[] {0,2,2}
        }));
        System.out.println(app.minCost(3, new int[][]{
                new int[] {2,0,12},
                new int[] {1,0,5},
                new int[] {0,1,15}
        }));
    }

}
