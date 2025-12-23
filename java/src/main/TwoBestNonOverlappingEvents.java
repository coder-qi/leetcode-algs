import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 */
public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        int[] f = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int startTime = events[i][0];
            int value = events[i][2];
            int j = lowerBound(events, 0, i, startTime);
            f[i + 1] = Math.max(value, f[j]);
            ans = Math.max(ans, value + f[j]);
        }
        return ans;
    }

    private int lowerBound(int[][] events, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (events[mid][1] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents app = new TwoBestNonOverlappingEvents();
        System.out.println(app.maxTwoEvents(ArrayUtils.matrix("[[1,3,2],[4,5,2],[2,4,3]]")));
        System.out.println(app.maxTwoEvents(ArrayUtils.matrix("[[10,83,53],[63,87,45],[97,100,32],[51,61,16]]")));
    }

}
