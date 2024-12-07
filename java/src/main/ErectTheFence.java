import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.matrix;
import static util.ArrayUtils.prints;

/**
 * 587. 安装栅栏：https://leetcode-cn.com/problems/erect-the-fence/
 */
public class ErectTheFence {

    public static int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        // 先找到最左侧的树（即X最小的点）
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[leftMost][0]) {
                leftMost = i;
            }
        }

        List<int[]> result = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int p = leftMost;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                if (cross(trees[p], trees[q], trees[r]) < 0) { // r在pq的右侧
                    q = r;
                }
            }

            // 找到和pq在同一条直线上的点i
            for (int i = 0; i < n; i++) {
                if (vis[i] || i == p || i == q) {
                    continue;
                }
                if (cross(trees[p], trees[q], trees[i]) == 0) {
                    result.add(trees[i]);
                    vis[i] = true;
                }
            }
            if (!vis[q]) { // 只将未处理过q的放入结果中
                result.add(trees[q]);
                vis[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return result.toArray(new int[][]{});
    }

    private static int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (r[0] - q[0]) * (q[1] - p[1]);
    }

    public static void main(String[] args) {
        System.out.println(prints(
            outerTrees(matrix("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]"))
        )); // [[1,1],[2,0],[4,2],[3,3],[2,4]]
        System.out.println(prints(
            outerTrees(matrix("[[1,2],[2,2],[4,2]]"))
        )); // [[1, 2],[2, 2],[4, 2]]
    }

}
