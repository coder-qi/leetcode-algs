package weekly.w295;

import static util.ArrayUtils.array;

/**
 * 6080. 使数组按非递减顺序排列：https://leetcode.cn/problems/steps-to-make-array-non-decreasing/
 */
public class StepsToMakeArrayNonDecreasing {

    public static int totalSteps(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        while (left < n) {
            while (left + 1 < n && nums[left] <= nums[left + 1]) {
                left++;
            }
            int right = left + 1;
            int cnt = 0;
            while (right < n && nums[left] > nums[right]) {
                cnt++;
                while (cnt == 1 && right + 1 < n && nums[right] > nums[right + 1]) {
                    right++;
                }
                right++;
                if (right < n && nums[right] < nums[right - 1]) {
                    break;
                }
            }
            left++;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(totalSteps(array("[5,14,15,2,11,5,13,15]"))); // 3
        System.out.println(totalSteps(array("[10,1,2,3,4,5,6,1,2,3]"))); // 6
        System.out.println(totalSteps(array("[5,3,4,4,7,3,6,11,8,5,11]"))); // 3
        System.out.println(totalSteps(array("[4,5,7,7,13]"))); // 0
    }

}
