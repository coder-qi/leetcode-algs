import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量：https://leetcode.cn/problems/maximum-ice-cream-bars
 */
public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) {
                break;
            }
            ans++;
        }
        return ans;
    }

}
