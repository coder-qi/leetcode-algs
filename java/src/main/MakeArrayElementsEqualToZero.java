/**
 * 3354. 使数组元素等于零：https://leetcode.cn/problems/make-array-elements-equal-to-zero
 */
public class MakeArrayElementsEqualToZero {

    public int countValidSelections(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res += dfs(nums, i, true);
                res += dfs(nums, i, false);
            }
        }
        return res;
    }

    private int dfs(int[] nums, int index, boolean left) {
        if (index < 0 || index == nums.length) {
            return isAllZeros(nums) ? 1 : 0;
        }
        int res = 0;
        if (nums[index] == 0) {
            res += dfs(nums, left ? index - 1 : index + 1, left);
        } else {
            nums[index]--;
            res += dfs(nums, left ? index + 1 : index - 1, !left);
            nums[index]++;
        }
        return res;
    }

    private boolean isAllZeros(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MakeArrayElementsEqualToZero soltion = new MakeArrayElementsEqualToZero();
        soltion.countValidSelections(new int[]{1,0,2,0,3});
    }

}
