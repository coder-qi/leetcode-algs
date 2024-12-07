
package weekly.w302;

import java.util.Arrays;
import java.util.Random;

import static util.ArrayUtils.matrix;

/**
 * 6121. 裁剪数字后查询第 K 小的数字：https://leetcode.cn/problems/query-kth-smallest-trimmed-number/
 */
public class QueryKthSmallestTrimmedNumber {

    Random random = new Random();

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += i < 10 ? "0" + i : String.valueOf(i);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0], trim = queries[i][1];
            String s = quickSelect(nums, nums[0].length() - trim - 2, k - 1, 0, nums.length - 1);
            ans[i] = Integer.valueOf(s.substring(s.length() - 2));
        }
        return ans;
    }

    private String quickSelect(String[] strs, int start, int k, int left, int right) {
        int q = randomPartition(strs, start, left, right);
        if (q == k) {
            return strs[q];
        } else {
            return q < k ? quickSelect(strs, start, k, q + 1, right) : quickSelect(strs, start, k, left, q - 1);
        }
    }

    private int randomPartition(String[] strs, int start, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(strs, i, right);
        return partition(strs, start, left, right);
    }

    private int partition(String[] strs, int start, int left, int right) {
        String x = strs[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (compare(strs[j], x, start) <= 0) {
                swap(strs, ++i, j);
            }
        }
        swap(strs, i + 1, right);
        return i + 1;
    }

    private void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int compare(String s1, String s2, int start) {
        for (int i = start; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(new QueryKthSmallestTrimmedNumber()
                .smallestTrimmedNumbers(new String[] {"102","473","251","814"},
                    matrix("[[1,1],[2,3],[4,2],[1,2]]")))); // [2,2,1,0]

        System.out.println(
            Arrays.toString(new QueryKthSmallestTrimmedNumber()
                .smallestTrimmedNumbers(new String[] {"24","37","96","04"},
                    matrix("[[2,1],[2,2]]"))));
    }

}
