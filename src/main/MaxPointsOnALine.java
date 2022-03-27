import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 直线上最多的点数：https://leetcode-cn.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {

    public static int maxPoints(int[][] points) {
        int n = points.length;
        Map<F, Set<Integer>> map = new HashMap<>();
        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = points[j][0] - points[i][0];
                double dy = points[j][1] - points[i][1];
                F f = new F();
                if (dx == 0) {
                    f.kx = (double) points[i][0];
                } else if (dy == 0) {
                    f.ky = (double) points[i][1];
                } else {
                    f.k = dy / dx;
                    f.b = f.k * points[j][0] - points[j][1];
                }
                Set<Integer> s = map.get(f);
                if (s == null) {
                    s = new HashSet<>();
                    map.put(f, s);
                }
                s.add(i);
                s.add(j);
                result = Math.max(result, s.size());
            }
        }
        return result;
    }

    static class F {
        double k;
        double b;
        Double kx;
        Double ky;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            F f = (F) o;
            return Double.compare(f.k, k) == 0 &&
                Double.compare(f.b, b) == 0 &&
                Objects.equals(kx, f.kx) &&
                Objects.equals(ky, f.ky);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, b, kx, ky);
        }
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{
            {1,1},{2,2},{3,3}
        }));
        System.out.println("-----");
        System.out.println(maxPoints(new int[][]{
            {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
        }));
        System.out.println("-----");
        System.out.println(maxPoints(new int[][]{
            {0,0}
        }));
        System.out.println("-----");
        System.out.println(maxPoints(new int[][]{
            {0,1},{0,2},{2,2},{1,0},{2,0}
        }));
    }

}
