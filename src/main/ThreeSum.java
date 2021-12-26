import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和：https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 排序加左右指针法
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 避免和上一次重复
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 最右侧指针
            int k = nums.length - 1;
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 避免和上一次重复
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                // 左右指针重合了，也就是说nums[j..]中的任意两数之和都大于target
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[0])); // []
        System.out.println(threeSum(new int[] {0})); // []
    }

}
