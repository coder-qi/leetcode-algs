import java.util.Arrays;

/**
 * 1723. 完成所有工作的最短时间：https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/
 */
public class FindMinimumTimeToFinishAllJobs {

    public static void main(String[] args) {

    }

    int ans = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        dfs(jobs, 0, new int[k]);
        return ans;
    }

    private void dfs(int[] jobs, int index, int[] workers) {
        if (index >= jobs.length) {
            int t = workers[0];
            for (int worker : workers) {
                t = Math.max(t, worker);
            }
            ans = Math.min(ans, t);
            return;
        }
        for (int i = 0; i < workers.length; i++) {
            workers[i] += jobs[index];
            if (workers[i] < ans) {
                dfs(jobs, index + 1, workers);
            }
            workers[i] -= jobs[index];
            if (workers[i] == 0) {
                break;
            }
        }
    }

}
