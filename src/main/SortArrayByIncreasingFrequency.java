import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序：https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {

    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return Arrays.stream(nums).boxed()
            .sorted((a, b) -> count.get(a) != count.get(b) ? count.get(a) - count.get(b) : b - a)
            .mapToInt(a -> a).toArray();
    }

}
