import util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 3531. 统计被覆盖的建筑：https://leetcode.cn/problems/count-covered-buildings
 */
public class CountCoveredBuildings {

    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Integer>> xCover = new HashMap<>(n, 1);
        Map<Integer,TreeSet<Integer>> yCover = new HashMap<>(n, 1);
        for (int[] building : buildings) {
            TreeSet<Integer> x = xCover.computeIfAbsent(building[0], _ -> new TreeSet<>());
            x.add(building[1]);
            TreeSet<Integer> y = yCover.computeIfAbsent(building[1], _ -> new TreeSet<>());
            y.add(building[0]);
        }

        int ans = 0;
        for (int[] building : buildings) {
            TreeSet<Integer> x = xCover.get(building[0]);
            TreeSet<Integer> y = yCover.get(building[1]);
            if (x.ceiling(building[1] + 1) != null && x.floor(building[1] - 1) != null &&
                    y.ceiling(building[0] + 1) != null && y.floor(building[0] - 1) != null) {
                ans++;
            }
        }
        return ans;
    }

    public int countCoveredBuildings2(int n, int[][] buildings) {
        int[][] xCover = new int[n + 1][2];
        int[][] yCover = new int[n + 1][2];
        for (int[] building : buildings) {
            int[] x = xCover[building[0]];
            x[0] = x[0] == 0 ? building[1] : Math.min(x[0], building[1]);
            x[1] = Math.max(building[1], x[1]);

            int[] y = yCover[building[1]];
            y[0] = y[0] == 0 ? building[0] : Math.min(y[0], building[0]);
            y[1] = Math.max(building[0], y[1]);
        }

        int ans = 0;
        for (int[] building : buildings) {
            int[] x = xCover[building[0]];
            int[] y = yCover[building[1]];
            if (building[1] > x[0] && building[1] < x[1] &&
                    building[0] > y[0] && building[0] < y[1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountCoveredBuildings app = new CountCoveredBuildings();
        System.out.println(app.countCoveredBuildings(5, ArrayUtils.matrix("[[1,3],[3,2],[3,3],[3,5],[5,3]]")));
        System.out.println(app.countCoveredBuildings(3, ArrayUtils.matrix("[[2,1],[2,3],[3,3],[2,2],[1,3]]")));
    }

}
