import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2087. 网格图中机器人回家的最小代价：https://leetcode.cn/problems/minimum-cost-homecoming-of-a-robot-in-a-grid
 */
public class MinimumCostHomecomingOfARobotInAGrid {

    static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minCost2(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{startPos[0], startPos[1], 0});
        boolean[][] visited = new boolean[m][n];
        visited[startPos[0]][startPos[1]] = true;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (a[0] == homePos[0] && a[1] == homePos[1]) {
                return a[2];
            }
            for (int[] d : DIRECTIONS) {
                int ni = a[0] + d[0];
                int nj = a[1] + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    int cost = a[0] == ni ? colCosts[nj] : rowCosts[ni];
                    pq.offer(new int[]{ni, nj, a[2] + cost});
                }
            }
        }
        return 0;
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        int i = startPos[0], si = startPos[0] < homePos[0] ? 1 : -1;
        while (i != homePos[0]) {
            i += si;
            res += rowCosts[i];
        }
        int j = startPos[1], sj = startPos[1] < homePos[1] ? 1 : -1;
        while (j != homePos[1]) {
            j += sj;
            res += colCosts[j];
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumCostHomecomingOfARobotInAGrid app = new MinimumCostHomecomingOfARobotInAGrid();
        System.out.println(app.minCost(new int[] {45, 70}, new int[] {32, 35},
                new int[] {4,10,5,8,0,10,5,9,10,2,7,7,7,6,1,1,5,1,5,9,7,1,0,3,1,2,6,4,6,4,2,4,1,1,5,2,3,9,3,9,8,4,1,4,6,6728,8650,6586,9762,9034,9246,5033,9632,6907,7237,6422,5603,6062,5033,5109,8118,7210,9672,8268,5157,5854,7723,8101},
                new int[] {7,8,9,8,10,3,10,4,8,10,7,5,5,9,7,5,7,10,8,6,2,2,4,10,7,3,6,2,1,8,1,6,5,5,1,9,10,6,3,2,8,6,3,0,10,4,5,4,6,2,1,6,8,9,3,0,5,6,8,3,8,6,10,4,6,4,3,3,6,3,6893,9916,9592,7854,8030,6396,8904,5191,9514,9417,9701,9840,9194,6515,5643,7804,9768,8898,6735,8548,6859,6024,9551,9520,5537,5135}));
    }

}
