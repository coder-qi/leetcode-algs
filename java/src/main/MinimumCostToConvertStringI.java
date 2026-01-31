import java.util.*;

/**
 * 2976. 转换字符串的最小成本 I：https://leetcode.cn/problems/minimum-cost-to-convert-string-i
 */
public class MinimumCostToConvertStringI {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<int[]>[] g = new List[27];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];
            g[u].add(new int[] {v, w});
        }
        Map<Integer, Integer> costMap = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            int c = calculateCost(g, costMap, u, v);
            if (c == -1) {
                return -1;
            }
            ans += c;
        }
        return ans;
    }

    private int calculateCost(List<int[]>[] g, Map<Integer, Integer> costMap, int u, int v) {
        int x = u + v * 27;
        if (costMap.containsKey(x)) {
            return costMap.get(x);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {u, 0});
        boolean[] visited = new boolean[27];
        int cost = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            if (cur[0] == v) {
                cost = cur[1];
                break;
            }
            for (int[] a : g[cur[0]]) {
                if (!visited[a[0]]) {
                    int y = a[0] + v * 27;
                    if (costMap.containsKey(y)) {
                        pq.offer(new int[] {v, cur[1] + a[1] + costMap.get(y)});
                    } else {
                        pq.offer(new int[] {a[0], cur[1] + a[1]});
                    }
                }
            }
        }

        costMap.put(x, cost);
        return cost;
    }

}
