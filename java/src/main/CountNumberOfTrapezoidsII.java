import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3625. 统计梯形的数目 II：https://leetcode.cn/problems/count-number-of-trapezoids-ii
 */
public class CountNumberOfTrapezoidsII {

    public int countTrapezoids(int[][] points) {
        Map<Double, Map<Double, Integer>> cnt1 = new HashMap<>();
        Map<Integer, Map<Double, Integer>> cnt2 = new HashMap<>();

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dy = y2 - y1;
                int dx = x2 - x1;
                double k = dx != 0 ? 1.0d * dy / dx : Double.MAX_VALUE;
                double b = dx != 0 ? 1.0d * (y2 * dx - dy * x2) / dx : x2;
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }

                cnt1.computeIfAbsent(k, _ -> new HashMap<>()).merge(b, 1, Integer::sum);

                int mid = (x1 + x2 + 2000) * 5000 + (y1 + y2 + 2000);
                cnt2.computeIfAbsent(mid, _ -> new HashMap<>()).merge(k, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Double, Integer> m : cnt1.values()) {
            int sum = 0;
            for (int c : m.values()) {
                ans += sum * c;
                sum += c;
            }
        }
        for (Map<Double, Integer> m : cnt2.values()) {
            int sum = 0;
            for (int c : m.values()) {
                ans -= sum * c;
                sum += c;
            }
        }
        return ans;
    }

    public int countTrapezoids2(int[][] points) {
        Map<Double, List<Double>> group1 = new HashMap<>();
        Map<Integer, List<Double>> group2 = new HashMap<>();

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dy = y2 - y1;
                int dx = x2 - x1;
                double k = dx != 0 ? 1.0d * dy / dx : Double.MAX_VALUE;
                double b = dx != 0 ? 1.0d * (y2 * dx - dy * x2) / dx : x2;
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }

                group1.computeIfAbsent(k, _ -> new ArrayList<>()).add(b);

                int mid = (x1 + x2 + 2000) * 5000 + (y1 + y2 + 2000);
                group2.computeIfAbsent(mid, _ -> new ArrayList<>()).add(k);
            }
        }

        int ans = 0;
        Map<Double, Integer> cnt = new HashMap<>();
        for (List<Double> g : group1.values()) {
            if (g.size() == 1) {
                continue;
            }
            cnt.clear();
            for (double d : g) {
                cnt.merge(d, 1, Integer::sum);
            }

            int sum = 0;
            for (int c : cnt.values()) {
                ans += sum * c;
                sum += c;
            }
        }
        for (List<Double> g : group2.values()) {
            if (g.size() == 1) {
                continue;
            }
            cnt.clear();
            for (double d : g) {
                cnt.merge(d, 1, Integer::sum);
            }

            int sum = 0;
            for (int c : cnt.values()) {
                ans -= sum * c;
                sum += c;
            }
        }
        return ans;
    }


}
