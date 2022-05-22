package weekly.w294;

import java.util.Arrays;

/**
 * 6075. 装满石头的背包的最大数量：https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/
 */
public class MaximumBagsWithFullCapacityOfRcks {

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n && additionalRocks >= 0; i++) {
            additionalRocks -= arr[i];
            if (additionalRocks >= 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
