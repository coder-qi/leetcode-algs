/**
 * 1608. 特殊数组的特征值：https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {

    }

    public static int specialArray(int[] nums) {
        int n = nums.length;
        for (int x = 1; x <= n; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        return -1;
    }


}
