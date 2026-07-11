import util.ArrayUtils;

import java.util.*;

/**
 * 2685. 统计完全连通分量的数量：https://leetcode.cn/problems/count-the-number-of-complete-components
 */
public class CountTheNumberOfCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges) {
        int[] degrees = new int[n];
        int[] idxs = new int[n];
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
            List<Integer> nodes = new ArrayList<>();
            m.put(i, nodes);
            nodes.add(i);
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degrees[u]++;
            degrees[v]++;
            if (idxs[u] != idxs[v]) {
                List<Integer> nodes = m.get(idxs[u]);
                List<Integer> otherNodes = m.remove(idxs[v]);
                for (int node : otherNodes) {
                    nodes.add(node);
                    idxs[node]= idxs[u];
                }
                idxs[v] = idxs[u];
            }
        }
        int ans = 0;
        for (List<Integer> nodes : m.values()) {
            boolean f = true;
            for (int node : nodes) {
                if (degrees[node] != nodes.size() - 1) {
                    f = false;
                    break;
                }
            }
            if (f) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents app = new CountTheNumberOfCompleteComponents();
        System.out.println(app.countCompleteComponents(6, ArrayUtils.matrix("[[0,1],[0,2],[1,2],[3,4]]")));
    }

}
