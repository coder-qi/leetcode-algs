import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值：https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }

}
