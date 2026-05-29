/**
 * 3300. 替换为数位和以后的最小元素：https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum
 */
public class MinimumElementAfterReplacementWithDigitSum {

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int s = 0;
            while (num != 0) {
                s += num % 10;
                num /= 10;
            }
            min = Math.min(min, s);
        }
        return min;
    }

}
