package weekly.w289;

import java.util.Arrays;

/**
 * 6071. 完成所有任务需要的最少轮数：https://leetcode-cn.com/problems/minimum-rounds-to-complete-all-tasks/comments/
 */
public class MinimumRoundsToCompleteAllTasks {

    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int n = tasks.length;
        int left = 0, ans = 0;
        while (left < n) {
            int right = left;
            while (right < n && tasks[left] == tasks[right]) {
                right++;
            }
            int count = right - left;
            if (count % 3 == 1) {
                if (count == 1) {
                    return -1;
                } else {
                    // 3 * c + 4
                    ans += (count - 4) / 3 + 2;
                }
            } else {
                ans += (count + 2) / 3;
            }
            left = right;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4}));
        System.out.println(minimumRounds(new int[] {5,5,5,5}));
    }

}
