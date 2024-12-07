import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            // 只处理序列的起始数字
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

}
