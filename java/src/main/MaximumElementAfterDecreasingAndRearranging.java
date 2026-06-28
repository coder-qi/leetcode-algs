import util.ArrayUtils;
import util.ResourceUtils;

import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素：https://leetcode.cn/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class MaximumElementAfterDecreasingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, Math.min(arr[i], ans + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumElementAfterDecreasingAndRearranging app = new MaximumElementAfterDecreasingAndRearranging();
        int[] arr = ArrayUtils.array(ResourceUtils.loadTestcase("1846-testcase-1.txt"));
        System.out.println(app.maximumElementAfterDecrementingAndRearranging(arr));
    }

}
