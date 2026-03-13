/**
 * 3296. 移山所需的最少秒数：https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero
 */
public class MinimumNumberOfSecondsToMakeMountainHeightZero {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxWorkerTime = 0;
        for (int workerTime : workerTimes) {
            maxWorkerTime = Math.max(maxWorkerTime, workerTime);
        }
        long left = 1;
        long right = (long) (1 + mountainHeight) * mountainHeight / 2 * maxWorkerTime;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mountainHeight, workerTimes, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mountainHeight, int[] workerTimes, long s) {
        long h = 0;
        for (int t : workerTimes) {
            long work = s / t;
            // 求最大的 k 满足 1+2+...+k <= work
            long k = (long)((-1.0 + Math.sqrt(1 + work * 8)) / 2);
            h += k;
        }
        return h >= mountainHeight;
    }

}
