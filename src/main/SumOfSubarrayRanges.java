import static util.ArrayUtils.array;

/**
 * 2104. 子数组范围和：https://leetcode.cn/problems/sum-of-subarray-ranges/
 */
public class SumOfSubarrayRanges {

    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subArrayRanges(array("[1,2,3]"))); // 4
        System.out.println(subArrayRanges(array("[1,3,3]"))); // 4
        System.out.println(subArrayRanges(array("[4,-2,-3,4,1]"))); // 59
    }

}
