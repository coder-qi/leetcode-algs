import util.ArrayUtils;

import java.util.*;

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
        
        List<PriorityQueue<Integer>> heaps = new ArrayList<>();
        heaps.add(new PriorityQueue<>());
        int[] belong = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            if (belong[i] == 0) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                dfs(i, heaps.size(), g, pq, belong);
                heaps.add(pq);
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] offline = new boolean[c + 1];
        for (int[] query : queries) {
            int op = query[0];
            int x = query[1];
            if (op == 1) {
                if (!offline[x]) {
                    ans.add(x);
                } else {
                    PriorityQueue<Integer> heap = heaps.get(belong[x]);
                    while (!heap.isEmpty() && offline[heap.peek()]) {
                        heap.poll();
                    }
                    ans.add(heap.isEmpty() ? -1 : heap.peek());
                }

            } else if (op == 2) {
                offline[x] = true;
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int x, int number, List<Integer>[] g, PriorityQueue<Integer> pq, int[] belong) {
        pq.add(x);
        belong[x] = number;
        for (int y : g[x]) {
            if (belong[y] == 0) {
                dfs(y, number, g, pq, belong);
            }
        }
    }

    public static void main(String[] args) {
        PowerGridMaintenance app = new PowerGridMaintenance();
        app.processQueries(3, ArrayUtils.matrix("[[3,2],[1,3],[2,1]]"), ArrayUtils.matrix("[[2,2],[1,2],[1,2],[1,3],[1,1],[1,3],[1,1],[1,1],[2,1],[1,1],[2,3],[2,3],[2,3],[2,1],[2,1],[2,1],[1,1],[1,1],[1,2],[1,2],[2,1],[2,1],[2,2],[1,2],[1,1]]"));
        app.processQueries(3, ArrayUtils.matrix("[[2,3]]"), ArrayUtils.matrix("[[2,2],[2,2],[1,2],[1,3],[2,1],[1,1],[2,2],[1,2],[1,1]]"));
    }

}
