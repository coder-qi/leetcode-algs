
package weekly.w302;

import java.util.Arrays;

import util.ArrayUtils;

/**
 * 6121. 裁剪数字后查询第 K 小的数字：https://leetcode.cn/problems/query-kth-smallest-trimmed-number/
 */
public class QueryKthSmallestTrimmedNumber {

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        String[] indexes = new String[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i < 10 ? "0" + i : String.valueOf(i);
        }
        String[] arr = new String[n];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            for (int j = 0; j < n; j++) {
                arr[j] = nums[j].substring(nums[j].length() - trim) + indexes[j];
            }
            Arrays.sort(arr);
            ans[i] = Integer.valueOf(arr[k - 1].substring(arr[k - 1].length() - 2));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(smallestTrimmedNumbers(new String[] {"24","37","96","04"},
                ArrayUtils.matrix("[[2,1],[2,2]]"))));
    }

}
