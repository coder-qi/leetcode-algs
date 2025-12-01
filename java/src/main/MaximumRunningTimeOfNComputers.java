/**
 * 2141. 同时运行 N 台电脑的最长时间：https://leetcode.cn/problems/maximum-running-time-of-n-computers
 */
public class MaximumRunningTimeOfNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long t = 0;
        for (int battery : batteries) {
            t += battery;
        }

        long left = 1;
        long right = t / n + 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long s = 0;
            for (int battery : batteries) {
                s += Math.min(mid, battery);
            }
            if (s >= n * mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        MaximumRunningTimeOfNComputers app = new MaximumRunningTimeOfNComputers();
        System.out.println(app.maxRunTime(2, new int[]{3,3,3}));
    }

}
