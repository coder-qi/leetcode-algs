import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2080. 区间内查询数字的频率：https://leetcode.cn/problems/range-frequency-queries/
 */
public class RangeFrequencyQueries {

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[] {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery.query(1, 2, 4)); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
        System.out.println(rangeFreqQuery.query(0, 11, 33)); // 返回 2 。33 在整个子数组中出现 2 次。
    }

}

class RangeFreqQuery {

    Map<Integer, List<Integer>> occurence = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //occurence.computeIfAbsent(arr[i], ArrayList::new).add(i);
            List<Integer> indexes = occurence.get(arr[i]);
            if (indexes == null) {
                indexes = new ArrayList<>();
                occurence.put(arr[i], indexes);
            }
            indexes.add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indexes = occurence.get(value);
        if (indexes == null) {
            return 0;
        }
        return upperBound(indexes, right) - lowerBound(indexes, left);
    }

    int lowerBound(List<Integer> list, int val) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (val <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int upperBound(List<Integer> list, int val) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (val >= list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}