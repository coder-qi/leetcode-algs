/**
 * 2483. 商店的最少代价：https://leetcode.cn/problems/minimum-penalty-for-a-shop
 */
public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        char[] strs = customers.toCharArray();
        int n = strs.length;
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + (strs[i] == 'Y' ? 1 : 0);
        }
        int minCost = suffixSum[0];
        int pre = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (strs[i - 1] == 'N') {
                pre++;
            }
            int cost = pre + suffixSum[i];
            if (cost < minCost) {
                minCost = cost;
                ans = i;
            }
        }
        return ans;
    }

    public int bestClosingTime2(String customers) {
        char[] strs = customers.toCharArray();
        int n = strs.length;
        int suffixY = 0;
        for (char ch : strs) {
            if (ch == 'Y') {
                suffixY++;
            }
        }
        int minCost = suffixY;
        int preN = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (strs[i] == 'N') {
                preN++;
            } else {
                suffixY--;
            }
            int cost = preN + suffixY;
            if (cost < minCost) {
                minCost = cost;
                ans = i + 1;
            }
        }
        return ans;
    }

    public int bestClosingTime3(String customers) {
        char[] strs = customers.toCharArray();
        int n = strs.length;
        int suffixY = 0;
        int minCost = 0;
        int preN = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (strs[i] == 'N') {
                preN++;
            } else {
                suffixY--;
            }
            int cost = preN + suffixY;
            if (cost < minCost) {
                minCost = cost;
                ans = i + 1;
            }
        }
        return ans;
    }

}
