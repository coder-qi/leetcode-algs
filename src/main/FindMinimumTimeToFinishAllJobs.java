import java.util.Arrays;

/**
 * 1723. 完成所有工作的最短时间：https://leetcode.cn/problems/find-minimum-time-to-finish-all-jobs/
 */
public class FindMinimumTimeToFinishAllJobs {

    public static void main(String[] args) {

    }

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int left = jobs[jobs.length - 1], right = Arrays.stream(jobs).sum();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] jobs, int k, int limit) {
        return dfs(jobs, new int[k], jobs.length - 1, limit);
    }

    private  boolean dfs(int[] jobs, int[] workers, int index, int limit) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < workers.length; i++) {
            workers[i] += jobs[index];
            if (workers[i] <= limit && dfs(jobs, workers, index - 1, limit)) {
                return true;
            }
            workers[i] -= jobs[index];
            if (workers[i] == 0 || workers[i] + jobs[index] == limit) {
                break;
            }
        }
        return false;
    }

}
