import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集：https://leetcode.cn/problems/largest-divisible-subset/description/
 */
public class LargestDivisibleSubset {

    // 暴力解，过于暴力，G
    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>(nums.length);
        List<Integer> combine = new ArrayList<>(nums.length);
        process2(nums, 0, 1, combine, result);
        return result;
    }

    private static void process2(int[] nums, int index, int base, List<Integer> combine, List<Integer> result) {
        for (int j = index; j < nums.length; j++) {
            if (nums[j] % base == 0) {
                combine.add(nums[j]);
                process2(nums, j + 1, nums[j], combine, result);
                if (combine.size() > result.size()) {
                    result.clear();
                    result.addAll(combine);
                }
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxValue = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<>(maxSize);
        if (maxSize == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                ans.add(nums[i]);
                maxValue = nums[i];
                maxSize--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[] {1, 2, 3})); // [1,2]或[1,3]
        System.out.println(largestDivisibleSubset(new int[] {1, 2, 4, 8})); // [1,2,4,8]
    }
}
