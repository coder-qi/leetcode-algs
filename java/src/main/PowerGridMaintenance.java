import util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 3607. 电网维护：https://leetcode.cn/problems/power-grid-maintenance
 */
public class PowerGridMaintenance {

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] g = new List[c + 1];
        for (int i = 0; i <= c; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            int x = conn[0], y = conn[1];
            g[x].add(y);
            g[y].add(x);
        }

        int cc = 1;
        int[] belong = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            if (belong[i] == 0) {
                dfs(i, cc, g, belong);
                cc++;
            }
        }

        int[] offlineTime = new int[c + 1];
        Arrays.fill(offlineTime, Integer.MAX_VALUE);
        for (int i = queries.length - 1; i >= 0; i--) {
            int op = queries[i][0], x = queries[i][1];
            if (op == 2) {
                offlineTime[x] = i;
            }
        }

        int[] mn = new int[c + 1];
        Arrays.fill(mn, Integer.MAX_VALUE);
        for (int i = 1; i <= c; i++) {
            if (offlineTime[i] == Integer.MAX_VALUE) {
                mn[belong[i]] = Math.min(mn[belong[i]], i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int op = queries[i][0], x = queries[i][1];
            if (op == 2) {
                if (offlineTime[x] == i) {
                    mn[belong[x]] = Math.min(mn[belong[x]], x);
                }
            } else if (op == 1) {
                if (i <= offlineTime[x]) {
                    ans.add(x);
                } else if (mn[belong[x]] != Integer.MAX_VALUE) {
                    ans.add(mn[belong[x]]);
                } else {
                    ans.add(-1);
                }
            }
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int x, int cc, List<Integer>[] g, int[] belong) {
        belong[x] = cc;
        for (int y : g[x]) {
            if (belong[y] == 0) {
                dfs(y, cc, g, belong);
            }
        }
    }

    public static void main(String[] args) {
        PowerGridMaintenance app = new PowerGridMaintenance();
        app.processQueries(3, ArrayUtils.matrix("[[3,2],[1,3],[2,1]]"), ArrayUtils.matrix("[[2,2],[1,2],[1,2],[1,3],[1,1],[1,3],[1,1],[1,1],[2,1],[1,1],[2,3],[2,3],[2,3],[2,1],[2,1],[2,1],[1,1],[1,1],[1,2],[1,2],[2,1],[2,1],[2,2],[1,2],[1,1]]"));
        app.processQueries(3, ArrayUtils.matrix("[[2,3]]"), ArrayUtils.matrix("[[2,2],[2,2],[1,2],[1,3],[2,1],[1,1],[2,2],[1,2],[1,1]]"));
    }

}
