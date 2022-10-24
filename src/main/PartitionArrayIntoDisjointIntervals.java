/**
 * 915. 分割数组：https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */
public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {

    }

    public static int partitionDisjoint(int[] nums) {
        int left = 0, leftMax = nums[0], rightMax = leftMax;
        for (int i = 1; i < nums.length; i++) {
            if (leftMax > nums[i]) {
                left = i;
                leftMax = rightMax;
            } else {
                rightMax = Math.max(rightMax, nums[i]);
            }
        }
        return left + 1;
    }

}
