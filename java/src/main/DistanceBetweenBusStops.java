/**
 * 1184. 公交站间的距离：https://leetcode.cn/problems/distance-between-bus-stops/
 */
public class DistanceBetweenBusStops {

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        // 顺时针
        int pos = start, total = 0;
        while (pos != destination) {
            total += distance[pos];
            pos = (pos + 1) % n;
        }
        // 逆时针
        int ans = total;
        pos = start;
        total = 0;
        while (pos != destination) {
            pos = (pos - 1 + n) % n;
            total += distance[pos];
        }
        ans = Math.min(ans, total);
        return ans;
    }

    public static void main(String[] args) {

    }

}
