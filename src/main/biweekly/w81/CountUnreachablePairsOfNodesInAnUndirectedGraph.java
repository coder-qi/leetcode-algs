package biweekly.w81;

import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 2316. 统计无向图中无法互相到达点对数：https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    List<List<Integer>> graph;
    boolean[] vis;

    public long countPairs(int n, int[][] edges) {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        vis = new boolean[n];

        long ans = 0;
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int count = dfs(i);
                ans += s * count;
                s += count;
            }
        }

        return ans;
    }

    private int dfs(int v) {
        if (vis[v]) {
            return 0;
        }
        vis[v] = true;
        int count = 1;
        for (int w : graph.get(v)) {
            count += dfs(w);
        }
        return count;
    }

    static long slove(int n, int[][] edges) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph g = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        return g.countPairs(n, edges);
    }

    public static void main(String[] args) {
        System.out.println(slove(3, matrix("[[0,1],[0,2],[1,2]]"))); // 0
        System.out.println(slove(7, matrix("[[0,2],[0,5],[2,4],[1,6],[5,4]]"))); // 14
    }

}
