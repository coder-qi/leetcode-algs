import java.util.Arrays;

/**
 * 324. 摆动排序 II：https://leetcode.cn/problems/wiggle-sort-ii/
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);
        int right = n - 1, left = (n + 1) / 2 - 1;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = arr[left--];
            } else {
                nums[i] = arr[right--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,1,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [1, 6, 1, 5, 1, 4]

        nums = new int[] {1,3,2,2,3,1};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 3, 1, 3, 1, 2]
    }

}
