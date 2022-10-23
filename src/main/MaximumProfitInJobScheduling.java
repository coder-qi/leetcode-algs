import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 1235. 规划兼职工作：https://leetcode.cn/problems/maximum-profit-in-job-scheduling
 */
public class MaximumProfitInJobScheduling {

    public static void main(String[] args) {

    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] idxes = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idxes, (a, b) -> startTime[a] != startTime[a] ? startTime[a] - startTime[b] : endTime[a] - endTime[b]);
        int[][] dp = new int[n][2];
        dp[0][1] = profit[idxes[0]];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (endTime[idxes[i - 1]] <= startTime[idxes[i]]) {
                dp[i][1] = profit[idxes[i]] + dp[i][0];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}
