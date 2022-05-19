import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 462. 最少移动次数使数组元素相等 II：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(array("[1,2,3]"))); // 2
        System.out.println(minMoves2(array("[1,10,2,9]"))); // 16
    }

}
