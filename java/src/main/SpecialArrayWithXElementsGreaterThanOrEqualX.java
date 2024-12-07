/**
 * 1608. 特殊数组的特征值：https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {

    }

    public static int specialArray(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;

            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }

            if (count < mid) {
                right = mid - 1;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
