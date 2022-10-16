import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.matrix;

/**
 * 886. 可能的二分法：https://leetcode.cn/problems/possible-bipartition/
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        System.out.println(new PossibleBipartition()
            .possibleBipartition(4, matrix("[[1,2],[1,3],[2,4]]")));
        System.out.println(new PossibleBipartition()
            .possibleBipartition(3, matrix("[[1,2],[1,3],[2,3]]")));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, graph, 1, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int v, List<Integer>[] graph, int nowColor, int[] color) {
        color[v] = nowColor;
        for (int w : graph[v]) {
            if (color[w] != 0 && color[w] == color[v]) {
                return false;
            }
            if (color[w] == 0 && !dfs(w, graph, 3 ^ nowColor, color)) {
                return false;
            }
        }
        return true;
    }

}
