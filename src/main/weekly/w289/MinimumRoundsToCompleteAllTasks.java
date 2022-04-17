package weekly.w289;

import java.util.HashMap;
import java.util.Map;

/**
 * 6071. 完成所有任务需要的最少轮数：https://leetcode-cn.com/problems/minimum-rounds-to-complete-all-tasks/comments/
 */
public class MinimumRoundsToCompleteAllTasks {

    public static int minimumRounds(int[] tasks) {
        int n = tasks.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int ans = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            if (count % 3 == 1) {
                // 3 * c + 4
                ans += (count - 4) / 3 + 2;
            } else {
                ans += (count + 2) / 3;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4}));
        System.out.println(minimumRounds(new int[] {5,5,5,5}));
    }

}
