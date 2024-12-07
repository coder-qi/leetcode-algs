package weekly.w301;

import java.util.Arrays;

/**
 * 6112. 装满杯子需要的最短总时长：https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
public class MinimumAmountOfTimeToFillCups {

    public static int fillCups(int[] amount) {
        Arrays.sort(amount);
        int ans = 0;
        if (amount[0] + amount[1] > amount[2]) {
            ans = (amount[0] + amount[1] + amount[2] + 1) / 2;
        } else {
            ans = amount[2];
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
