
package weekly.w302;

import java.util.Arrays;

import util.ArrayUtils;

/**
 * 6121. 裁剪数字后查询第 K 小的数字：https://leetcode.cn/problems/query-kth-smallest-trimmed-number/
 */
public class QueryKthSmallestTrimmedNumber {

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        String[][] arr = new String[nums.length][2];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            for (int j = 0; j < arr.length; j++) {
                arr[j][0] = nums[j].substring(nums[j].length() - trim);
                arr[j][1] = String.valueOf(j);
            }
            Arrays.sort(arr, (a, b) -> {
                if (a[0].compareTo(b[0]) == 0) {
                    return Long.compare(Integer.valueOf(a[1]), Integer.valueOf(b[1]));
                }
                return a[0].compareTo(b[0]);
            });
            ans[i] = Integer.valueOf(arr[k - 1][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(smallestTrimmedNumbers(new String[] {"24","37","96","04"},
                ArrayUtils.matrix("[[2,1],[2,2]]"))));
    }

}
