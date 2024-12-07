/**
 * 908. 最小差值 I：https://leetcode-cn.com/problems/smallest-range-i/
 */
public class SmallestRangeI {

    public static int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        min += k;
        max -= k;
        return max < min ? 0 : max - min;
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[] {1}, 0)); // 0
        System.out.println(smallestRangeI(new int[] {0,10}, 2)); // 2
        System.out.println(smallestRangeI(new int[] {1,3,6}, 3)); // 3
    }

}
