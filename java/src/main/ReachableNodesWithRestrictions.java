import java.util.ArrayList;
import java.util.List;

/**
 * 2368. 受限条件下可到达节点的数目：https://leetcode.cn/problems/reachable-nodes-with-restrictions
 */
public class ReachableNodesWithRestrictions {

    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>(2));
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[n];
            for (int index : restricted) {
                visited[index] = true;
            }
            return process(adj, 0, visited);
        }

        private int process(List<List<Integer>> adj, int w, boolean[] visited) {
            if (visited[w]) {
                return 0;
            }
            visited[w] = true;
            int ans = 1;
            for (int v : adj.get(w)) {
                ans += process(adj, v, visited);
            }
            return ans;
        }
    }

}
