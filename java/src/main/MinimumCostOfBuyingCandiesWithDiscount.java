import java.util.Arrays;

/**
 * 2144. 打折购买糖果的最小开销：https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount
 */
public class MinimumCostOfBuyingCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i - 1 >= 0) {
                ans += cost[i - 1];
            }
        }
        return ans;
    }

}
