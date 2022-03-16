import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int prevLen = map.getOrDefault(nums[i] - 1, 0);
                int nextLen = map.getOrDefault(nums[i] + 1, 0);
                int currentLen = prevLen + nextLen + 1;
                map.put(nums[i], currentLen);
                map.put(nums[i] - prevLen, currentLen);
                map.put(nums[i] + nextLen, currentLen);
                max = Math.max(max, currentLen);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

}
