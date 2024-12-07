/**
 * 多数元素：https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int result = nums[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i + 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[] {6,5,5}));
    }

}
