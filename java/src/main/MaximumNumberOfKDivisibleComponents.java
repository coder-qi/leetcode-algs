import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.array;
import static util.ArrayUtils.matrix;

/**
 * 2872. 可以被 K 整除连通块的最大数目：https://leetcode.cn/problems/maximum-number-of-k-divisible-components
 */
public class MaximumNumberOfKDivisibleComponents {

    private int ans = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        return dfs(0, -1, g, values, k) == 0 ? ans : 0;
    }

    private int dfs(int u, int fa, List<Integer>[] g, int[] values, int k) {
        int x = values[u] % k;
        for (int v : g[u]) {
            if (v != fa) {
                x = (x + dfs(v, u, g, values, k)) % k;
            }
        }
        if (x == 0) {
            ans++;
        }
        return x;
    }

    public static void main(String[] args) {
        MaximumNumberOfKDivisibleComponents app = new MaximumNumberOfKDivisibleComponents();
        System.out.println(app.maxKDivisibleComponents(5,
                matrix("[[0,2],[1,2],[1,3],[2,4]]"),
                array("[1,8,1,4,4]"),
                6)); // 2
        app = new MaximumNumberOfKDivisibleComponents();
        System.out.println(app.maxKDivisibleComponents(7,
                matrix("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]"),
                array("[3,0,6,1,5,2,1]"),
                3)); // 3
    }

}
