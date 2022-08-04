import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列：https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
public class MinimumSubsequenceInNonIncreasingOrder {

    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[] {4,3,10,9,8})); // [10,9]
        System.out.println(minSubsequence(new int[] {4,4,7,6,7})); // [7,7,6]
        System.out.println(minSubsequence(new int[] {6})); // [6]
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        for (int i = n - 1, subSum = 0; subSum <= sum; i--) {
            subSum += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
        }
        return ans;
    }

}
