/**
 * 2574. 左右元素和的差值：https://leetcode.cn/problems/left-and-right-sum-differences/
 */
public class LeftAndRightSumDifferences {

    public int[] leftRightDifference(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        int[] diff = new int[nums.length];
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = s - leftSum - nums[i];
            diff[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return diff;
    }

}
