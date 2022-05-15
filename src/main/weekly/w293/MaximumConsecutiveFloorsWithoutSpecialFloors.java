package weekly.w293;

import java.util.Arrays;

/**
 * 6064. 不含特殊楼层的最大连续楼层数：https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/
 */
public class MaximumConsecutiveFloorsWithoutSpecialFloors {

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0] - bottom;
        for (int i = 1; i <= special.length; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        ans = Math.max(ans, top - special[special.length - 1]);
        return ans;
    }

    public static void main(String[] args) {

    }

}
