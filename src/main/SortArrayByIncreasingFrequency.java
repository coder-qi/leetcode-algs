import java.util.Arrays;

/**
 * 1636. 按照频率将数组升序排序：https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {

    }

    public static int[] frequencySort(int[] nums) {
        int[] vals = new int[201];
        for (int num : nums) {
            if (vals[num + 100] == 0) {
                vals[num + 100] = 100 - num;
            }
            vals[num + 100] += 201;
        }
        Arrays.sort(vals);
        int[] ans = new int[nums.length];
        int pos = 0;
        for (int v : vals) {
            for (int i = 0, count = v / 201, num = 100 - v % 201; i < count; i++) {
                ans[pos++] = num;
            }
        }
        return ans;
    }

}
