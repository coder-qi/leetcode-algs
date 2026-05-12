import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1665. 完成所有任务的最少初始能量：https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks
 */
public class MinimumInitialEnergyToFinishTasks {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;
        int s = 0;
        for (int[] t : tasks) {
            int actual = t[0];
            int minimum = t[1];
            ans = Math.max(ans, s + minimum);
            s += actual;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumInitialEnergyToFinishTasks app = new MinimumInitialEnergyToFinishTasks();
        System.out.println(app.minimumEffort(ArrayUtils.matrix("[[1,3],[2,4],[10,11],[10,12],[8,9]]")));
    }

}
