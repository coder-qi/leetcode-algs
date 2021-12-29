import static util.ArrayUtils.print;

/**
 * 移除元素：https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    /**
     * 双指针法
     */
    public static int removeElementNormal(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }

    /**
     * 双指针优化：右边的元素移动到左边
     */
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
           if (nums[left] == val) {
               nums[left] = nums[right - 1];
               right--;
           } else {
               left++;
           }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(print(nums, removeElement(nums, 3)));
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println(print(nums2, removeElement(nums2, 2)));
    }

}
