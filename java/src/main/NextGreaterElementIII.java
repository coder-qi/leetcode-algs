/**
 * 556. 下一个更大元素 III：https://leetcode.cn/problems/next-greater-element-iii/
 */
public class NextGreaterElementIII {

    public static int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        return ans <= Integer.MAX_VALUE ? (int)ans : -1;
    }

    private static void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12)); // 21
        System.out.println(nextGreaterElement(21)); // -1
        System.out.println(nextGreaterElement(101)); // 110
        System.out.println(nextGreaterElement(230241)); // 230412
        System.out.println(nextGreaterElement(2147483486)); // -1
        System.out.println(nextGreaterElement(2147483476)); // 2147483647
    }

}
