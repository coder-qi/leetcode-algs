import java.util.Arrays;

/**
 * 3075. 幸福值最大化的选择方案：https://leetcode.cn/problems/maximize-happiness-of-selected-children
 */
public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        for (int i = n - 1; i >= n - k; i--) {
            int x = happiness[i] - (n - i - 1);
            if (x > 0) {
                ans += x;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximizeHappinessOfSelectedChildren app = new MaximizeHappinessOfSelectedChildren();
        System.out.println(app.maximumHappinessSum(new int[] {1,2,3}, 2));
    }

}
