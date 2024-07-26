import java.util.Arrays;

/**
 * 2740. 找出分区值：https://leetcode.cn/problems/find-the-value-of-the-partition
 */
public class FindTheValueOfThePartition {

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

}
