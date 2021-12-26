import java.util.Arrays;

/**
 * 最接近的三数之和：https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1)); // 2
        System.out.println(threeSumClosest(new int[] {0,0,0}, 1)); // 0
        System.out.println(threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1)); // -2
        System.out.println(threeSumClosest(new int[] {1,2,5,10,11}, 12)); // 13
    }

}
