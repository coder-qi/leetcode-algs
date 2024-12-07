import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 905. 按奇偶排序数组
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            if (left < right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(array("[3,1,2,4]"))));
        System.out.println(Arrays.toString(sortArrayByParity(array("[0]"))));
    }

}
