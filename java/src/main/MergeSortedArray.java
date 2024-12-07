import java.util.Arrays;

/**
 * 合并两个有序数组：https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        merge(nums1, 3, new int[] {2,5,6}, 3);
        System.out.println(Arrays.toString(nums1)); // [1,2,2,3,5,6]

        nums1 = new int[] {1};
        merge(nums1, 1, new int[] {}, 0);
        System.out.println(Arrays.toString(nums1)); // [1]

        nums1 = new int[] {0};
        merge(nums1, 0, new int[] {1}, 1);
        System.out.println(Arrays.toString(nums1)); // [1]
    }

}
