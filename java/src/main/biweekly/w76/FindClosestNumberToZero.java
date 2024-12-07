package biweekly.w76;

/**
 * 找到最接近 0 的数字：https://leetcode-cn.com/problems/find-closest-number-to-zero/
 */
public class FindClosestNumberToZero {


    public static int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(ans)) {
                ans = nums[i];
            } else if (Math.abs(nums[i]) == Math.abs(ans)) {
                if (nums[i] > ans) {
                    ans = nums[i];
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[] {-4,-2,1,4,8}));
        System.out.println(findClosestNumber(new int[] {2,-1,1}));
    }

}
