import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数：https://leetcode-cn.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnALine {

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result >= n - i || result > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + 20001 * x;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            result = Math.max(result, maxn);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
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
