import java.util.HashMap;
import java.util.Map;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2nArray {

    public static int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 2 * n; i++) {
            int count = countMap.getOrDefault(nums[i], 0);
            if (count == n - 1) {
                return nums[i];
            }
            countMap.put(nums[i], count + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] {1,2,3,3})); // 3
        System.out.println(repeatedNTimes(new int[] {2,1,2,5,3,2})); // 2
        System.out.println(repeatedNTimes(new int[] {5,1,5,2,5,3,5,4})); // 5

    }

}
