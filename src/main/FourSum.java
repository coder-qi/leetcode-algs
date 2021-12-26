import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和：https://leetcode-cn.com/problems/4sum/
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k - 1] == nums[k]) {
                        continue;
                    }
                    int val = target - (nums[i] + nums[j] + nums[k]);
                    int r = nums.length - 1;
                    while (k < r && nums[r] > val) {
                        r--;
                    }
                    if (k == r) {
                        break;
                    }
                    if (val == nums[r]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[r]));
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {1,0,-1,0,-2,2}, 0)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(fourSum(new int[] {2,2,2,2,2}, 8)); // [[2,2,2,2]]
        System.out.println(fourSum(new int[] {-3,-1,0,2,4,5}, 0)); // [[-3,-1,0,4]]
        System.out.println(fourSum(new int[] {-1,0,1,2,-1,-4}, -1)); // [[-4,0,1,2],[-1,-1,0,1]]
    }

}
