package weekly.w286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.ArrayUtils;

import static util.ArrayUtils.array;

/**
 * 2215. 找出两数组的不同：https://leetcode.cn/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums2) {
            s2.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i : s1) {
            if (!s2.contains(i)) {
                result.get(0).add(i);
            }
        }
        for (int i : s2) {
            if (!s1.contains(i)) {
                result.get(1).add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [[1,3],[4,6]]
        System.out.println(findDifference(array("[1,2,3]"), array("[2,4,6]")));
        // [[3],[]]
        System.out.println(findDifference(array("[1,2,3,3]"), array("[1,1,2,2]")));
    }

}
