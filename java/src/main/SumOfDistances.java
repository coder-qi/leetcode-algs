import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2615. 等值距离和：https://leetcode.cn/problems/sum-of-distances
 */
public class SumOfDistances {

    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            group.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }
        long[] res = new long[nums.length];
        for (List<Integer> pos : group.values()) {
            if (pos.size() <= 1) {
                continue;
            }
            long[] preSum = new long[pos.size()];
            preSum[0] = pos.getFirst();
            for (int i = 1; i < pos.size(); i++) {
                preSum[i] = preSum[i - 1] + pos.get(i);
            }
            for (int i = 0; i < pos.size(); i++) {
                long left = i == 0 ? 0 : (long) pos.get(i) * i - preSum[i - 1];
                long right = preSum[preSum.length - 1] - preSum[i] - (long) (pos.size() - i - 1) * pos.get(i);
                res[pos.get(i)] = left + right;
            }
        }
        return res;
    }

}
