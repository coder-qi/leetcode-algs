import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2956. 找到两个数组中的公共元素：https://leetcode.cn/problems/find-common-elements-between-two-arrays
 */
public class FindCommonElementsBetweenTwoArrays {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());
        int count1 = 0;
        for (int num : nums1) {
            if (set2.contains(num)) {
                count1++;
            }
        }
        int count2 = 0;
        for (int num : nums2) {
            if (set1.contains(num)) {
                count2++;
            }
        }
        return new int[] {count1, count2};
    }

}
