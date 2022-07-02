import java.util.PriorityQueue;

import static util.ArrayUtils.matrix;

/**
 * 871. 最低加油次数：https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 */
public class MinimumNumberOfRefuelingStops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int fuel = startFuel;
        int ans = 0;
        for (int i = 0; i <= stations.length; i++) {
            int distance = distance(stations, i, target);
            while (!pq.isEmpty() && fuel < distance) {
                fuel += pq.poll()[1];
                ans++;
            }
            if (pq.isEmpty() && fuel < distance) {
                return -1;
            }
            fuel -= distance;
            if (i < stations.length) {
                pq.offer(stations[i]);
            }
        }
        return ans;
    }

    private static int distance(int[][] stations, int index, int target) {
        if (stations.length == 0) {
            return target;
        }
        if (index == 0) {
            return stations[index][0];
        } else if (index == stations.length) {
            return target - stations[index - 1][0];
        } else {
            return stations[index][0] - stations[index - 1][0];
        }
    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(1, 1, matrix("[]"))); // 0
        System.out.println(minRefuelStops(100, 1, matrix("[[10,100]]"))); // -1
        System.out.println(minRefuelStops(100, 10, matrix("[[10,60],[20,30],[30,30],[60,40]]"))); // 2
    }

}
