package weekly.w296;

import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 6091. 划分数组使最大差为 K：https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] - nums[j] > k) {
                ans++;
                j = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(array("[2,2,4,5]"), 0));
        System.out.println(partitionArray(array("[16,8,17,0,3,17,8,20]"), 10));
    }

}
