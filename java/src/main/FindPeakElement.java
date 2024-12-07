/**
 * 寻找峰值：https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            boolean greaterLeft = mid - 1 < 0 || nums[mid] > nums[mid - 1];
            boolean greaterRight = mid + 1 >= nums.length || nums[mid] > nums[mid + 1];
            if (greaterLeft && greaterRight) {
                left = mid;
                break;
            } else if (!greaterRight) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,3,1}));
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }

}
