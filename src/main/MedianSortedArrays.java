import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianSortedArrays {

    /**
     * 合并排序数组法
     * 思路：合并两个数组，然后将数组进行排序，直接取合并数组的中位数即可
     */
    public static double findMedianSortedArraysByMergeArrays(int[] nums1, int[] nums2) {
        int[] mergeNums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergeNums, 0, nums1.length);
        System.arraycopy(nums2, 0, mergeNums, nums1.length, nums2.length);
        Arrays.sort(mergeNums);
        double medianNum;
        if (mergeNums.length % 2 != 0) {
            medianNum = mergeNums[mergeNums.length/2];
        } else {
            int half = mergeNums.length/2;
            medianNum = (mergeNums[half - 1] + mergeNums[half])/2.0;
        }
        return medianNum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int median1 = 0, median2 = 0;
        if (m != 0 && n != 0) {
            if (nums1[m - 1] < nums2[0]) {
                left = m;
            } else if (nums1[0] > nums2[n-1]) {
                right = 0;
            }
        }
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            // 划分区间num1[0..i-1], num2[0..j-1]
            // 划分区间num1[i..m-1], num2[j..n-1]

            // num1[i-1]
            int numsIm1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            // num1[i]
            int numsI = i == m ? Integer.MAX_VALUE : nums1[i];
            // num2[j-1]
            int numsJm1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            // num2[j]
            int numsJ = j == n ? Integer.MAX_VALUE : nums2[j];
            if (numsIm1 <= numsJ) {
                median1 = Math.max(numsIm1, numsJm1);
                median2 = Math.min(numsI, numsJ);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4})); // 2.5
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0,0})); // 0
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1})); // 1
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{})); // 2
    }

}
